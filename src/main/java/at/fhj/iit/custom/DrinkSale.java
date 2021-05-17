package at.fhj.iit.custom;

import at.fhj.iit.base.Drink;

import java.time.LocalDateTime;

public class DrinkSale {
    private final Drink drink;
    private final double price;
    private final Operator operator;
    private final LocalDateTime soldAt;

    public DrinkSale(Drink drink, Operator operator) {
        this.drink = drink;
        this.operator = operator;
        this.soldAt = LocalDateTime.now();
        this.price = drink.calculatePrice();
    }

    public double getPrice() {
        return price;
    }

    public Operator getOperator() {
        return operator;
    }

    public LocalDateTime getSoldAt() {
        return soldAt;
    }

    public Drink getDrink() {
        return drink;
    }
}
