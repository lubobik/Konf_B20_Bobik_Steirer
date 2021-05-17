package at.fhj.iit.custom.misc;

import at.fhj.iit.base.Liquid;

/**
 * Mainly used as a mixing fluid.
 * Describes a <code>SoftLiquid</code> object (with data access)
 * and offers manipulation options.
 *
 * @author Andreas Steirer
 * @version 1.0
 * @see Liquid
 */
public class SoftLiquid extends Liquid {

    /*
     * Field declaration
     */
    protected Brand brand;

    /**
     * Creates a new <code>SoftLiquid</code> with given name, volume and brand.
     *
     * @param name   a name of a soft drink
     * @param volume a volume of a soft drink
     * @param brand  a <code>Brand</code> of a soft drink
     */
    public SoftLiquid(String name, double volume, Brand brand) {
        super(name, volume, 0.0);
        this.brand = brand;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getVolume() {
        return super.getVolume();
    }

    @Override
    public void setVolume(double volume) {
        super.setVolume(volume);
    }

    /**
     * Returns the <code>Brand</code> of the soft drink.
     *
     * @return the <code>Brand</code> enumeration of the soft drink
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Setter for <code>Brand</code> enumeration
     *
     * @param brand the new <code>Brand</code> value
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "The SoftLiquid '" + getName() + "' is manufactured by '" + brand + "' and got a standard volume of " + getVolume() + " liters.";
    }
}
