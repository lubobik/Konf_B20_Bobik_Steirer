package at.fhj.iit;

public class SoftDrink extends Liquid {

    private Brand brand;

    /**
     * Creates new liquid with given name, volume and
     * alcoholPercent
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "This SoftDrink is named: '" + getName() + "' is from the brand '" + brand + "' and got a volume of " + getVolume() + " liters.";
    }
}
