package at.fhj.iit.custom;

import at.fhj.iit.base.Drink;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class CashRegisterManagement {
    private final ArrayList<DrinkSale> sales;

    public CashRegisterManagement() {
        this.sales = new ArrayList<>();
    }

    public void addSale(DrinkSale drinkSale) {
        sales.add(drinkSale);
    }

    public double retrieveTotalOfNonAlcoholicBeverages() {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> !sale.getDrink().isAlcoholic())
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalOfAlcoholicBeveragesWeak() {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() <= 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalOfAlcoholicBeveragesIntense() {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> {
                    Drink drink = sale.getDrink();
                    return drink.isAlcoholic() && drink.getAlcoholPercent() > 16.0;
                })
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalByTimestamp(LocalDate soldAt) {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> sale.getSoldAt().toLocalDate().equals(soldAt))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalByOperator(Operator soldBy) {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> sale.getOperator().equals(soldBy))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }

    public double retrieveTotalByOperatorAndTimestamp(LocalDate soldAt, Operator soldBy) {
        return DrinkUtils.roundToTwoDecimals(sales
                .stream()
                .filter(sale -> sale.getSoldAt().toLocalDate().equals(soldAt) && sale.getOperator().equals(soldBy))
                .mapToDouble(DrinkSale::getPrice)
                .sum()
        );
    }
}
