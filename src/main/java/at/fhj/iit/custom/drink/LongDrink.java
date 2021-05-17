package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;

/**
 * Describes a <code>LongDrink</code> object, with methods to calculate Volume/alcoholic percentage
 *
 * @author Lukas Bobik
 * @version 2.0
 * @see Drink
 * @since 2.0
 */
public class LongDrink extends Drink {
    protected Liquid alcoholic;
    protected Liquid softLiquid;

    /**
     * Creates a LongDrink object with a give name, one alcoholic liquid and a softLiquid
     *
     * @param name       name of the drink
     * @param alcoholic  the alcoholic liquid of a longdrink
     * @param softLiquid the nonalcoholic liquid of a longdrink
     */
    public LongDrink(String name, Liquid alcoholic, Liquid softLiquid) {
        super(name);
        this.alcoholic = alcoholic;
        this.softLiquid = softLiquid;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return alcoholic.getVolume() + softLiquid.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return (alcoholic.getAlcoholPercent() * alcoholic.getVolume() + softLiquid.getAlcoholPercent() * softLiquid.getVolume()) / getVolume();

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
     * Formatted output of a Cocktail object
     */
    @Override
    public String toString() {
        return name + " like the name suggests is " + alcoholic.getName() + " and " + softLiquid.getName() + " with an alcohol percentage of " + getAlcoholPercent() + "%.";
    }
}
