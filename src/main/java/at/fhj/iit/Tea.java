package at.fhj.iit;

public class Tea extends Drink{

    /**
     * uses only one liquid
     */
    protected Liquid t;
    protected Boolean sugar;

    /**
     * Creates a Tea object with given name and liquid
     * @param name name of drink
     * @param t only one liquid in drink, because it's a simple drink an not e.g. a cocktail
     */
    Tea(String name, Liquid t){
        super(name);
        this.t = t;
    }

    /**
     * Creates a Tea object with given name, liquid and sugar
     *
     * @param name name of drink
     * @param t only one liquid in drink, because it's a simple drink an not e.g. a cocktail
     * @param sugar tells if the tea is with or without sugar
     */
    Tea(String name, Liquid t, Boolean sugar){
        super(name);
        this.t = t;
        this.sugar=sugar;
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

    /**
     * Returns alcohol volume percent of liquid l
     *
     * @return alcohol volume percent
     */
    @Override
    public double getAlcoholPercent() {
        return t.getAlcoholPercent();
    }

    /**
     * Gives information if drink is alcoholic or not
     *
     * @return true when alcoholic liquids are present, otherwise false
     */
    @Override
    public boolean isAlcoholic() {
        if(t.getAlcoholPercent() > 0){
            return true;
        }
        return false;
    }

    public String toString(){
        if (sugar){

            return "Tea " + name + " with " + t.getAlcoholPercent() + " percent alcohol by volume and sugar";
        }
        return "Tea " + name + " with " + t.getAlcoholPercent() + " percent alcohol by volume without sugar";
    }
}
