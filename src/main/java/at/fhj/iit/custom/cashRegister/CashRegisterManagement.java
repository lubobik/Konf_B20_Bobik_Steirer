package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Drink;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a CashRegister in form of a certain <code>DrinkSale</code> history.
 * Next to managing the sales history (in this case only additions are allowed),
 * there is also the possibility to retrieve and
 * print reports from its corresponding sales history.
 *
 * @author Andreas Steirer
 * @author Lukas Bobik
 * @version 3.0
 */
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

    /*
     * Section:
     * Management
     */

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

    /*
     * Section:
     * Report metric calculations
     */

    /**
     * Retrieves the total of all non-alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @return the total of all non-alcoholic <code>Drink</code> sales
     */
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

    /**
     * Retrieves the total of all <code>Drink</code>s by a potential date
     * from the current <code>DrinkSale</code> history.
     * <p>
     * Fallback:
     * In case of <code>soldAt</code> being <code>null</code>,
     * it will return the total of all days.
     *
     * @param soldAt a potential date / day on which the sale occurred or <code>null</code>
     * @return the total of all <code>Drink</code> sales on the passed date or of all days
     */
    public double retrieveTotalByDate(LocalDate soldAt) {
        return soldAt != null ? DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getSoldAt().toLocalDate().equals(soldAt))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        ) : retrieveTotal();
    }

    /**
     * Retrieves the total of all <code>Drink</code>s
     * sold by a potential <code>Operator</code>
     * from the current <code>DrinkSale</code> history.
     * <p>
     * Fallback:
     * In case of <code>soldBy</code> being <code>null</code>,
     * it will return the total of all days.
     *
     * @param soldBy a potential <code>Operator</code> who achieved
     *               the sale or <code>null</code>
     * @return the total of all <code>Drink</code> sales for the potential
     * <code>Operator</code> or of all <code>Operator</code>s
     */
    public double retrieveTotalByOperator(Operator soldBy) {
        return soldBy != null ? DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .filter(sale -> sale.getOperator().equals(soldBy))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        ) : retrieveTotal();
    }

    /**
     * Retrieves the total of all <code>Drink</code>s
     * sold at a potential date and by a potential <code>Operator</code>
     * from the current <code>DrinkSale</code> history.
     * <p>
     * Fallback cases:
     * - If both <code>soldAt</code> and <code>soldBy</code> are <code>null</code>, return the complete total
     * - If <code>soldAt</code> is <code>null</code>, return the complete total for all <code>Operator</code>s
     * - If <code>soldBy</code> is <code>null</code>, return the complete total for all dates / days
     * - If both <code>soldAt</code> and <code>soldBy</code> are NOT <code>null</code>, return the specific total
     *
     * @param soldAt a potential date / day on which the sale occurred
     *               (in case of <code>null</code>, all <code>Operator</code>s will be considered)
     * @param soldBy a potential <code>Operator</code> who achieved the sale
     *               (in case of <code>null</code>, all days / dates will be considered)
     * @return the total of all <code>Drink</code> sales for the passed date and <code>Operator</code>
     */
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

    /**
     * Retrieves the total of all <code>Drink</code>s
     * sold and tracked within the current <code>DrinkSale</code> history.
     *
     * @return the total of all <code>Drink</code> sales
     */
    public double retrieveTotal() {
        return DrinkUtils.roundToTwoDecimals(salesHistory
                .stream()
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    /*
     * Section:
     * Report printing / Formatted output
     */

    /**
     * Prints the total of sales of all <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     */
    public void printTotal() {
        DrinkUtils.printFormattedMetric(
                "Total of all operators and days",
                retrieveTotal()
        );
    }

    /**
     * Prints the total of all non-alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     */
    public void printTotalOfNonAlcoholic() {
        DrinkUtils.printFormattedMetric("Total of non-alcoholic beverages",
                retrieveTotalOfNonAlcoholicBeverages()
        );
    }

    /**
     * Prints the total of all weak alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     */
    public void printTotalOfWeakAlcoholic() {
        DrinkUtils.printFormattedMetric("Total of intense alcoholic beverages",
                retrieveTotalOfAlcoholicBeveragesWeak()
        );
    }

    /**
     * Prints the total of all intense alcoholic <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     */
    public void printTotalOfIntenseAlcoholic() {
        DrinkUtils.printFormattedMetric("Total of weak alcoholic beverages",
                retrieveTotalOfAlcoholicBeveragesIntense()
        );
    }

    /**
     * Prints the total of sales of all <code>Drink</code>s by
     * a potential <code>Operator</code>
     * from the current <code>DrinkSale</code> history.
     *
     * @param soldBy a potential <code>Operator</code> who achieved the sales.
     *               In case of <code>null</code>, the total of overall sales is printed.
     */
    public void printTotalByOperator(Operator soldBy) {
        if (soldBy != null) {
            DrinkUtils.printFormattedMetric(
                    "Total of operator '" + soldBy.getFullName() + "'",
                    retrieveTotalByOperator(soldBy)
            );
        } else printTotal();
    }

    /**
     * Prints the total of all <code>Drink</code>s
     * of all <code>Operator</code>s separately for an optional
     * specific day / date from the current <code>DrinkSale</code> history.
     *
     * @param soldAt a potential date / day on which the sale occurred.
     *               In case of <code>null</code>, total of all days are printed.
     */
    public void printTotalByEachOperator(LocalDate soldAt) {
        salesHistory
                .stream()
                .map(DrinkSale::getOperator)
                .collect(Collectors.toSet())
                .forEach(operator -> printTotalByDateAndOperator(soldAt, operator));
    }

    /**
     * Prints the total of sales of all <code>Drink</code>s
     * from the current <code>DrinkSale</code> history.
     *
     * @param soldAt a potential date / day on which the sale occurred.
     *               In case of <code>null</code>, total of overall sales is printed.
     */
    public void printTotalByDate(LocalDate soldAt) {
        if (soldAt != null) {
            DrinkUtils.printFormattedMetric(
                    "Total of the day '" + soldAt + "'",
                    retrieveTotalByDate(soldAt)
            );
        } else printTotal();
    }

    /**
     * Prints the total of all <code>Drink</code>s
     * sold by a potential <code>Operator</code> and on a potential day / date
     * from the current <code>DrinkSale</code> history.
     * <p>
     * Cases:
     * - If both <code>soldAt</code> and <code>soldBy</code> are <code>null</code>, the complete total is printed
     * - If only <code>soldAt</code> is <code>null</code>, the complete total for all <code>Operator</code>s is printed
     * - If only <code>soldBy</code> is <code>null</code>, the complete total for all dates / days is printed
     * - If both <code>soldAt</code> and <code>soldBy</code> are NOT <code>null</code>, the specific total is printed
     *
     * @param soldAt a potential date / day on which the sale occurred.
     *               In case of <code>null</code>, overall sales by a <code>Operator</code> gets printed.
     * @param soldBy a potential <code>Operator</code> who achieved the sales
     */
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