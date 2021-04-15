package at.fhj.iit.base;

/**
 * Represents a <code>SimpleDrink</code>
 * with a <code>Liquid</code> which can be used in drinks.
 *
 * @author Michael Ulm
 * @author Christian Hofer
 * @version 2.0
 * @see Drink
 * @since 1.0
 */
public class SimpleDrink extends Drink {

    /**
     * A single liquid of the drink
     */
    protected Liquid l;

    /**
     * Creates a SimpleDrink object with given name and liquid.
     *
     * @param name name of drink
     * @param l    only one liquid in drink, because it's a simple drink an not e.g. a cocktail
     */
    public SimpleDrink(String name, Liquid l) {
        super(name);
        this.l = l;
    }

    /**
     * Returns volume of liquid l.
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        return l.getVolume();
    }

    /**
     * Returns alcohol volume percent of liquid l.
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return l.getAlcoholPercent();
    }

    /**
     * Gives information if drink is alcoholic or not.
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        return l.getAlcoholPercent() > 0;
    }

    /**
     * Formatted output of a Cocktail object
     */
    @Override
    public String toString() {
        return "Simple Drink called " + name + " with " + l.getAlcoholPercent() + " percent alcohol by volume";
    }
}
