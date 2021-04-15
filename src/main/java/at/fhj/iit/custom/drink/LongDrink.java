package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;


public class LongDrink extends Drink {
    protected Liquid alcoholic;
    protected Liquid softdrink;

    /**
     * Creates a LongDrink object with a give name, one alcoholic liquid and a softdrink
     *
     * @param name      name of the drink
     * @param alcoholic the alcoholic liquid of a longdrink
     * @param softdrink the nonalcoholic liquid of a longdrink
     */
    public LongDrink(String name, Liquid alcoholic, Liquid softdrink) {
        super(name);
        this.alcoholic = alcoholic;
        this.softdrink = softdrink;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    @Override
    public double getVolume() {
        return alcoholic.getVolume() + softdrink.getVolume();
    }

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    @Override
    public double getAlcoholPercent() {
        return (alcoholic.getAlcoholPercent() * alcoholic.getVolume() + softdrink.getAlcoholPercent() * softdrink.getVolume()) / getVolume();

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
        return name + " like the name suggests is " + alcoholic.getName() + " and " + softdrink.getName() + " with an alcohol percentage of " + getAlcoholPercent() + "%.";
    }
}
