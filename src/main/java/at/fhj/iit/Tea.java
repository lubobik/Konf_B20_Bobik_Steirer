package at.fhj.iit;

public class Tea extends Drink {

    /**
     * uses one liquid, and possibly milk and/or sugar
     */
    protected Liquid t;
    protected Boolean sugar;
    protected Boolean milk;

    /**
     * Creates a Tea object with given name and liquid
     *
     * @param name name of drink
     * @param t    only one liquid(water) in drink
     */
    Tea(String name, Liquid t) {
        super(name);
        this.t = t;
    }
 
    /**
     * Creates a Tea object with given name, liquid and sugar
     *
     * @param name  name of drink
     * @param t     only one liquid(water) in drink, because it's a tea
     * @param sugar tells if the tea is with or without sugar
     * @param milk  tells if the tea is with or without milk
     */
    Tea(String name, Liquid t, Boolean sugar, Boolean milk) {
        super(name);
        this.t = t;
        this.sugar = sugar;
        this.milk = milk;
    }

    /**
     * Tells if the tea has milk or not
     *
     * @return true, if there is milk in the tea
     */
    public boolean getMilk() {
        return sugar;
    }

    /**
     * Tells if the tea has sugar or not
     *
     * @return true, if there is sugar in the tea
     */
    public boolean getSugar() {
        return sugar;
    }

    /**
     * Returns volume of liquid
     *
     * @return the volume of drink in litre
     */
    @Override
    public double getVolume() {
        return t.getVolume();
    }

    @Override
    public double getAlcoholPercent() {
        return 0;
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return always false, we dont allow tea with "schuss"
     */
    @Override
    public boolean isAlcoholic() {
        return false;
    }

    public String toString() {
        String text = "This tea is from sort " + name + " with";
        if (sugar && milk) {
            text += " sugar and milk";
        } else if (sugar) {
            text += " sugar";
        } else if (milk) {
            text += " milk";
        } else {
            text += "out milk or sugar";
        }
        return text;
    }

}
