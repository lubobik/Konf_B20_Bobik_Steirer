package at.fhj.iit.base;


/**
 * Abstract base class for concrete <code>Drink</code> classes.
 *
 * @author Michael Ulm
 * @author Christian Hofer
 * @version 1.0
 * @see Drink
 * @since 1.0
 */
public abstract class Drink {

    /**
     * name of the drink, so it's easier to identify drink
     */
    protected String name;

    /**
     * Creates a <code>Drink</code> object with given name, e.g. juice or orange juice
     *
     * @param name name of the <code>Drink</code>
     */

    public Drink(String name) {
        this.name = name;
    }

    /**
     * Calculates and returns volume of drink
     *
     * @return the volume of drink in liter
     */
    public abstract double getVolume();

    /**
     * Calculates and returns the alcohol percentage
     *
     * @return alcohol volume percent (e.g. 50)
     */
    public abstract double getAlcoholPercent();

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    public abstract boolean isAlcoholic();
}
