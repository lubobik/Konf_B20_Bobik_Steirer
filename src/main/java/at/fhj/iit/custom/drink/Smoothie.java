package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.misc.Fruit;

import java.util.List;

/**
 * Describes a <code>Smoothie</code> object
 *
 * @author Lukas Bobik
 * @version 2.0
 * @see Drink
 * @since 1.0
 */
public class Smoothie extends Drink {
    protected Liquid l;
    protected Boolean sugar;
    private final List<Fruit> fruitlist;

    /**
     * Creates a Smoothie object with given name, baseliquid, Fruits and sweetener
     *
     * @param name        name of drink
     * @param baseliquid, tells us the base of the smoothie (eg milk, juice...)
     * @param fruitlist   is a list from fruits that are mixed together
     * @param sweetener   tells if the smoothie is sweetened
     */
    public Smoothie(String name, Liquid baseliquid, List<Fruit> fruitlist, boolean sweetener) {
        super(name);
        this.fruitlist = fruitlist;
        this.l = baseliquid;
        this.sugar = sweetener;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return l.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return l.getAlcoholPercent();
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    /**
     * Formatted output for a Smoothie
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Here, have a nice Smoothie, it's a mix from " + l.getName() + " and ");
        boolean first = true;
        for (Fruit fruit : fruitlist) {
            if (first) {
                text.append(fruit.getName());
                first = false;
            } else {
                text.append(", ").append(fruit.getName());
            }
        }
        text.append(".");
        if (sugar) text.append("It's even sweetened.");
        if (l.getName().equals("milk") || l.getName().equals("Milk"))
            text.append("\nAnd guess what, as the base is milk, it's even better than a normal smoothie. It's a milkshake!");
        return text.toString();
    }

    /**
     * Calculates the price of the drink,
     * based on its ingredients and specialities.
     *
     * @return the calculated price of a specific drink
     */
    @Override
    public double calculatePrice() {
        double multiplier = 1 + (sugar ? 1 : 0) + fruitlist.size();
        return getVolume() * (1.0 + (getAlcoholPercent() / 100.0)) * multiplier;
    }
}



