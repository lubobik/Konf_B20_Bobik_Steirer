package at.fhj.iit;

public class SoftDrink extends Liquid {

    protected Brand brand;

    /**
     * Creates a new SoftDrink with given name, volume and brand
     *
     * @param name   a name of a soft drink
     * @param volume a volume of a soft drink
     * @param brand  a brand of a soft drink
     */
    public SoftDrink(String name, double volume, Brand brand) {
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
     * Returns the brand of the soft drink
     *
     * @return the brand enumeration of the soft drink
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Setter for Brand enumeration
     *
     * @param brand the new Brand value
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "The SoftDrink '" + getName() + "' is manufactured by '" + brand + "' and got a standard volume of " + getVolume() + " liters.";
    }
}
