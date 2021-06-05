package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Drink;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CashRegisterManagement {

    /**
     * The history of all <code>DrinkSale</code> objects
     * of this particular <code>CashRegisterManagement</code> instance
     * (source of report generation).
     */
    private final List<DrinkSale> salesHistory;

    /**
     * Initialisation of the <code>DrinkSale</code> history.
     */
    public CashRegisterManagement() {
        this.salesHistory = new ArrayList<>();
    }

    /**
     * Initialisation of the <code>DrinkSale</code> history,
     * with an already available history.
     */
    public CashRegisterManagement(List<DrinkSale> salesHistory) {
        this.salesHistory = salesHistory;
    }

    /**
     * Getter to retrieve the current sales history.
     *
     * @return the current <code>DrinkSale</code> history entries.
     */
    public List<DrinkSale> getSalesHistory() {
        return salesHistory;
    }

    /**
     * Adds the passed <code>DrinkSale</code> to
     * the current <code>DrinkSale</code> history list.
     *
     * @param drinkSale a specific <code>DrinkSale</code>
     */
    public void addDrinkSale(DrinkSale drinkSale) {
        salesHistory.add(drinkSale);
    }

    /**
     * Adds the passed <code>DrinkSale</code>s list and
     * therefore its entries to the current <code>DrinkSale</code> history list.
     *
     * @param drinkSales specific <code>DrinkSale</code> entries
     */
    public void addMultiDrinkSales(List<DrinkSale> drinkSales) {
        salesHistory.addAll(drinkSales);
    }

    public double retrieveTotalOfNonAlcoholicBeverages() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> !sale.getDrink().isAlcoholic())
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all weak alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all weak alcoholic <code>Drink</code> sales
     */
    public double retrieveTotalOfAlcoholicBeveragesWeak() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() <= 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /**
     * Retrieves the total of all intense alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all intense alcoholic <code>Drink</code> sales
     */
    public double retrieveTotalOfAlcoholicBeveragesIntense() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() > 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalByDate(LocalDate soldAt) {
        return soldAt != null ? DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getSoldAt().toLocalDate().equals(soldAt))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        ) : retrieveTotal();
    }

    public double retrieveTotalByOperator(Operator soldBy) {
        return soldBy != null ? DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getOperator().equals(soldBy))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        ) : retrieveTotal();
    }

    public double retrieveTotalByDateAndOperator(LocalDate soldAt, Operator soldBy) {
        boolean isNoSaleDate = soldAt == null;
        boolean isNoOperator = soldBy == null;

        if (isNoSaleDate && isNoOperator) return retrieveTotal();

        if (isNoSaleDate) return retrieveTotalByOperator(soldBy);

        if (isNoOperator) return retrieveTotalByDate(soldAt);

        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale ->
                        sale.getSoldAt().toLocalDate().equals(soldAt)
                                && sale.getOperator().equals(soldBy)
                )
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotal() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public void printTotal() {
        DrinkUtils.printFormattedMetric(
                "Total of all operators and days",
                retrieveTotal()
        );
    }

    public void printNonAlcoholic() {
        DrinkUtils.printFormattedMetric("Total of non-alcoholic beverages",
                retrieveTotalOfNonAlcoholicBeverages()
        );
    }

    public void printAlcoholicWeak() {
        DrinkUtils.printFormattedMetric("Total of intense alcoholic beverages",
                retrieveTotalOfAlcoholicBeveragesWeak()
        );
    }

    public void printAlcoholicIntense() {
        DrinkUtils.printFormattedMetric("Total of weak alcoholic beverages",
                retrieveTotalOfAlcoholicBeveragesIntense()
        );
    }

    public void printTotalByOperator(Operator soldBy) {
        if (soldBy != null) {
            DrinkUtils.printFormattedMetric(
                    "Total of operator '" + soldBy.getFullName() + "'",
                    retrieveTotalByOperator(soldBy)
            );
        } else printTotal();
    }

    public void printTotalByEachOperator(LocalDate soldAt) {
        salesHistory
                .stream()
                .map(DrinkSale::getOperator)
                .collect(Collectors.toSet())
                .forEach(operator -> printTotalByDateAndOperator(soldAt, operator));
    }

    public void printTotalByDate(LocalDate soldAt) {
        if (soldAt != null) {
            DrinkUtils.printFormattedMetric(
                    "Total of the day '" + soldAt + "'",
                    retrieveTotalByDate(soldAt)
            );
        } else printTotal();
    }

    public void printTotalByDateAndOperator(LocalDate soldAt, Operator soldBy) {
        String message;
        boolean isSaleDate = soldAt != null;
        boolean isOperator = soldBy != null;

        if (!isSaleDate && !isOperator) {
            message = "Total of all operators of all time";
        } else if (isSaleDate && isOperator) {
            message = "Total of the day '" + soldAt + "' for operator '" + soldBy.getFullName() + "'";
        } else if (isOperator) {
            message = "Total of operator and all days '" + soldBy.getFullName() + "'";
        } else {
            message = "Total of day '" + soldAt + "' and all operators";
        }

        DrinkUtils.printFormattedMetric(
                message,
                retrieveTotalByDateAndOperator(soldAt, soldBy)
        );
    }
}
