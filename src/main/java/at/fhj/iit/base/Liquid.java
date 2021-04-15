package at.fhj.iit.base;

/**
 * Represents a <code>Liquid</code> which can be used in drinks.
 *
 * @author Michael Ulm
 * @author Christian Hofer
 * @version 2.0
 * @see Drink
 * @since 1.0
 */
public class Liquid {

    /**
     * Name of a <code>Liquid</code>
     */
    private String name;

    /**
     * Volume of a <code>Liquid</code> (in liter)
     */
    private double volume;

    /**
     * Alcohol percentage of a <code>Liquid</code> (in percent eg. 42)
     */
    private double alcoholPercent;

    /**
     * Creates new <code>Liquid</code> with given name, volume and
     * alcohol percentage
     *
     * @param name           name of liquid
     * @param volume         volume of liquid
     * @param alcoholPercent of liquid
     */
    public Liquid(String name, double volume, double alcoholPercent) {
        this.name = name;
        checkVolume(volume);

        this.volume = volume;
        this.alcoholPercent = alcoholPercent;
    }

    /**
     * Checks if the passed volume is lower than or equal to zero.
     * If so, throws a <code>ValidationException</code>.
     *
     * @param volume which should be checked
     */
    private void checkVolume(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("liquid " + name + " must have a volume > 0");
        }
    }

    /**
     * Getter for name
     *
     * @return the name of <code>Liquid</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name a new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for volume
     *
     * @return the volume of liquid (in liter)
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter for volume
     *
     * @param volume a new volume
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Getter for alcohol percentage
     *
     * @return the alcohol percentage (e.g. 40)
     */
    public double getAlcoholPercent() {
        return alcoholPercent;
    }

    /**
     * Setter for alcohol percentage
     *
     * @param alcoholPercent a new alcohol percentage
     */
    public void setAlcoholPercent(double alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }
}

