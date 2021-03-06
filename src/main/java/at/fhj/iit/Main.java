package at.fhj.iit;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import at.fhj.iit.custom.cashRegister.CashRegisterManagement;
import at.fhj.iit.custom.cashRegister.Operator;
import at.fhj.iit.custom.drink.Cocktail;
import at.fhj.iit.custom.drink.LongDrink;
import at.fhj.iit.custom.drink.Smoothie;
import at.fhj.iit.custom.drink.Tea;
import at.fhj.iit.custom.misc.Brand;
import at.fhj.iit.custom.misc.Fruit;
import at.fhj.iit.custom.misc.SoftLiquid;
import at.fhj.iit.util.CashRegisterRandomizer;
import at.fhj.iit.util.DrinkUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * Contains the main application logic.
 *
 * @author Andreas Steirer
 * @author Lukas Bobik
 * @version 3.0
 * @see Drink
 * @since 1.0
 */
public final class Main {

    /**
     * Required to reach full Jacoco code coverage.
     */
    private Main() {
    }

    /**
     * Represents the main entry point of
     * every Java application.
     *
     * @param args Command line parameters
     */
    public static void main(String[] args) {
        printBaseDemonstration();
        DrinkUtils.printSeparator();

        printSoftLiquidDemonstration();
        DrinkUtils.printSeparator();

        printTeaDemonstration();
        DrinkUtils.printSeparator();

        printCocktailDemonstration();
        DrinkUtils.printSeparator();

        printSmoothieDemonstration();
        DrinkUtils.printSeparator();

        printLongDrinkDemonstration();
        DrinkUtils.printSeparator();

        printCashRegisterManagementDemonstration();
    }

    /**
     * Demonstrates the base implementation (<code>Liquid</code> and <code>SimpleDrink</code>).
     */
    private static void printBaseDemonstration() {
        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink redWine = new SimpleDrink("Rotwein", l);
        System.out.println(redWine);

        DrinkUtils.printSeparator();
        System.out.println("END OF ALREADY SPECIFIED CODE");
    }

    /**
     * Demonstrates the <code>SoftLiquid</code> implementation.
     */
    private static void printSoftLiquidDemonstration() {
        SoftLiquid softLiquid = new SoftLiquid("Orange juice", 0.5, Brand.COCA_COLA);
        System.out.println(softLiquid);
    }

    /**
     * Demonstrates the <code>Tea</code> implementation.
     */
    private static void printTeaDemonstration() {
        Liquid water = new Liquid("Water", 0.3, 0);
        Drink earlyGrey = new Tea("Early Grey", water, true, true);
        System.out.println(earlyGrey);
    }

    /**
     * Demonstrates the <code>Cocktail</code> implementation.
     */
    private static void printCocktailDemonstration() {
        List<Liquid> maiTaiLiquids = List.of(
                new Liquid("Rum", 2.0, 40.0),
                new Liquid("Cointreau", 0.5, 35.0),
                new Liquid("Orgeat Syrup", 0.5, 0.0),
                new Liquid("Lime Juice", 0.5, 0.0),
                new Liquid("Water", 2, 0.0)
        );
        Cocktail maiTai = new Cocktail("Mai Tai", maiTaiLiquids);
        System.out.println(maiTai);
    }

    /**
     * Demonstrates the <code>Smoothie</code> implementation.
     */
    private static void printSmoothieDemonstration() {
        Liquid milk = new Liquid("Milk", 0.5, 0);
        List<Fruit> smoothieFruits = List.of(
                new Fruit("Strawberry"),
                new Fruit("Banana"),
                new Fruit("Ananas")
        );

        Smoothie milkshake = new Smoothie("Milkshake", milk, smoothieFruits, false);
        System.out.println(milkshake);
    }

    /**
     * Demonstrates the <code>LongDrink</code> implementation.
     */
    private static void printLongDrinkDemonstration() {
        Liquid vodka = new Liquid("Vodka", 0.3, 40);
        SoftLiquid filler = new SoftLiquid("Cranberry Juice", 0.5, Brand.PEPSI);
        LongDrink vodkaCranberry = new LongDrink("Vodka Cranberry", vodka, filler);
        System.out.println(vodkaCranberry);
    }

    /**
     * Demonstrates the <code>CashRegisterManagement</code> implementation.
     */
    private static void printCashRegisterManagementDemonstration() {
        CashRegisterManagement cashRegister =
                CashRegisterRandomizer.generateRandomTestCashRegister();

        LocalDate today = LocalDate.now();
        Operator operator = CashRegisterRandomizer.retrieveRandomOperator();

        cashRegister.printTotalOfIntenseAlcoholic();
        DrinkUtils.printSeparator();

        cashRegister.printTotalOfNonAlcoholic();
        DrinkUtils.printSeparator();

        cashRegister.printTotalOfWeakAlcoholic();
        DrinkUtils.printSeparator();

        cashRegister.printTotal();
        DrinkUtils.printSeparator();

        /*
         * Fallback implementation check:
         * Equivalent to printTotal()
         */
        cashRegister.printTotalByDate(null);
        DrinkUtils.printSeparator();

        cashRegister.printTotalByDate(today);
        DrinkUtils.printSeparator();

        /*
         * Fallback implementation check:
         * Equivalent to printTotal()
         */
        cashRegister.printTotalByOperator(null);
        DrinkUtils.printSeparator();

        cashRegister.printTotalByOperator(operator);
        DrinkUtils.printSeparator();

        // Prints the sum of each operator
        cashRegister.printTotalByEachOperator(today);
        DrinkUtils.printSeparator();

        /*
         * Fallback implementation check:
         * Prints the sum of a all operators of all days.
         * Equivalent to
         */
        cashRegister.printTotalByDateAndOperator(null, null);
        DrinkUtils.printSeparator();

        /*
         * Fallback implementation check:
         * Prints the sum of a specific operator for all days
         */
        cashRegister.printTotalByDateAndOperator(null, operator);
        DrinkUtils.printSeparator();

        /*
         * Fallback implementation check:
         * Prints the sum of a specific date for all Operators
         */
        cashRegister.printTotalByDateAndOperator(today, null);
        DrinkUtils.printSeparator();

        // Prints the sum of a specific date and Operator
        cashRegister.printTotalByDateAndOperator(today, operator);
    }
}
