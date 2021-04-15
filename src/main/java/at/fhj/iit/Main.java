package at.fhj.iit;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import at.fhj.iit.custom.drink.Cocktail;
import at.fhj.iit.custom.drink.LongDrink;
import at.fhj.iit.custom.drink.Smoothie;
import at.fhj.iit.custom.drink.Tea;
import at.fhj.iit.custom.misc.Brand;
import at.fhj.iit.custom.misc.Fruit;
import at.fhj.iit.custom.misc.SoftDrink;

import java.util.List;

/**
 * Contains the main application logic.
 *
 * @author Andreas Steirer
 * @author Lukas Bobik
 * @version 2.0
 * @see Drink
 * @since 1.0
 */
public class Main {

    /**
     * Represents the main entry point of a Java application.
     *
     * @param args Command line parameters
     */
    public static void main(String[] args) {
        printBaseDemonstration();
        printSeparator();

        System.out.println("END OF ALREADY SPECIFIED CODE");
        printSeparator();

        printSoftDrinkDemonstration();
        printSeparator();

        printTeaDemonstration();
        printSeparator();

        printCocktailDemonstration();
        printSeparator();

        printSmoothieDemonstration();
        printSeparator();

        printLongDrinkDemonstration();
    }

    /**
     * Demonstrates the base implementation (<code>Liquid</code> and <code>SimpleDrink</code>).
     */
    private static void printBaseDemonstration() {
        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein", l);
        System.out.println(d);
    }

    /**
     * Demonstrates the <code>SoftDrink</code> implementation.
     */
    private static void printSoftDrinkDemonstration() {
        SoftDrink softDrink = new SoftDrink("Orange juice", 0.5, Brand.COCA_COLA);
        System.out.println(softDrink);
    }

    /**
     * Demonstrates the <code>Tea</code> implementation.
     */
    private static void printTeaDemonstration() {
        Liquid w = new Liquid("Water", 0.3, 0);
        Drink t = new Tea("Early Grey", w, true, true);
        System.out.println(t);
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
        SoftDrink filler = new SoftDrink("Cranberry Juice", 0.5, Brand.PEPSI);
        LongDrink vodkaCranberry = new LongDrink("Vodka Cranberry", vodka, filler);
        System.out.println(vodkaCranberry);
    }

    /**
     * Prints a dashed line out of 80 characters to the console.
     */
    private static void printSeparator() {
        System.out.println("-".repeat(80));
    }
}
