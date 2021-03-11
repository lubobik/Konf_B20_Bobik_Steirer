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
     * @param t    only one liquid in drink, because it's a simple drink an not e.g. a cocktail
     */
    Tea(String name, Liquid t) {
        super(name);
        this.t = t;
    }

    /**
     * Creates a Tea object with given name, liquid and sugar
     *
     * @param name  name of drink
     * @param t     only one liquid in drink, because it's a simple drink an not e.g. a cocktail
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
     * Returns volume of liquid l
     *
     * @return the volume of drink in litre
     */
    public boolean getSugar() {
        return sugar;
    }

    /**
     * Returns volume of liquid l
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
        }else{text+="out milk or sugar";}


        return text;
    }

}
