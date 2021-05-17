package at.fhj.iit.util;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.CashRegisterManagement;
import at.fhj.iit.custom.DrinkSale;
import at.fhj.iit.custom.Operator;
import at.fhj.iit.custom.drink.Cocktail;
import at.fhj.iit.custom.drink.LongDrink;
import at.fhj.iit.custom.drink.Smoothie;
import at.fhj.iit.custom.drink.Tea;
import at.fhj.iit.custom.misc.Fruit;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class CashRegisterRandomizer {

    private static CashRegisterManagement cashRegisterManagement;
    private static final Faker faker = new Faker();
    private static final List<Operator> operators = List.of(
            new Operator("Andreas", "Steirer"),
            new Operator("Lukas", "Bobik"),
            new Operator("Michael", "Ulm"),
            new Operator("Christian", "Hofer")
    );

    public static CashRegisterManagement generateRandomTestCashRegister() {
        cashRegisterManagement = new CashRegisterManagement();

        generateRandomCocktails();
        generateRandomLongDrinks();
        generateRandomSmoothies();
        generateRandomTeas();

        return cashRegisterManagement;
    }

    public static Operator randomOperator() {
        return operators.get(faker.number().numberBetween(0, operators.size() - 1));
    }

    private static void generateRandomCocktails() {
        ArrayList<Liquid> liquids = new ArrayList<>();
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
                liquids.add(randomLiquid(faker.random().nextBoolean()));
            }
            cashRegisterManagement.addSale(
                    new DrinkSale(
                            new Cocktail(faker.beer().name(), liquids),
                            randomOperator()
                    )
            );
        }
    }

    private static void generateRandomLongDrinks() {
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            cashRegisterManagement.addSale(
                    new DrinkSale(
                            new LongDrink(
                                    faker.beer().name(),
                                    randomLiquid(true),
                                    randomLiquid(false)
                            ),
                            randomOperator()
                    )
            );
        }
    }

    private static void generateRandomSmoothies() {
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
                fruits.add(new Fruit(faker.food().fruit()));
            }
            cashRegisterManagement.addSale(
                    new DrinkSale(
                            new Smoothie(
                                    faker.beer().name(),
                                    randomLiquid(false),
                                    fruits,
                                    faker.random().nextBoolean()
                            ),
                            randomOperator()
                    )
            );
        }
    }

    private static void generateRandomTeas() {
        for (int i = 0; i < faker.number().numberBetween(1, 5); i++) {
            cashRegisterManagement.addSale(
                    new DrinkSale(
                            new Tea(
                                    faker.beer().name(),
                                    randomLiquid(false),
                                    faker.random().nextBoolean(),
                                    faker.random().nextBoolean()
                            ),
                            randomOperator()
                    )
            );
        }
    }

    private static Liquid randomLiquid(boolean isAlcoholic) {
        return new Liquid(faker.food().ingredient(), randomVolume(), isAlcoholic ? randomPercentage() : 0.0);
    }

    private static double randomVolume() {
        return faker.number().randomDouble(2, 1, 10);
    }

    private static double randomPercentage() {
        return faker.number().randomDouble(2, 0, 100);
    }
}
