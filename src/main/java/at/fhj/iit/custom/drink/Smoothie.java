package at.fhj.iit.custom.drink;

import at.fhj.iit.base.Drink;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.misc.Fruit;

import java.util.List;

public class Smoothie extends Drink {
    protected Liquid l;
    protected Boolean sugar;
    private final List<Fruit> fruitlist;

    /**
     * Creates a Smoothie object with given name, baseliquid, Fruits and sweetener
     *
     * @param name        name of drink
     * @param baseliquid, tells us the base of the smoothie (eg milk, juice...)
     * @param sweetener   tells if the smoothie is sweetened
     * @param fruitlist   is a list from fruits that are mixed together
     */
    public Smoothie(String name, Liquid baseliquid, List<Fruit> fruitlist, boolean sweetener) {
        super(name);
        this.fruitlist = fruitlist;
        this.l = baseliquid;
        this.sugar = sweetener;
    }


    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getAlcoholPercent() {
        return 0;
    }

    @Override
    public boolean isAlcoholic() {
        return false;
    }

    /**
     * Formatted output for a Smoothie
     */
    public String toString() {
        StringBuilder text = new StringBuilder("Here, have a nice Smoothie, it's a mix from " + l.getName() + " and ");
        boolean first = true;
        for (Fruit fruit : fruitlist) {
            if (first) {
                text.append(fruit.getName());
                first = false;
            } else {
                text.append(", ").append(fruit.getName());
            }
        }
        text.append(".");
        if (sugar) text.append("It's even sweetened.");
        if (l.getName().equals("milk") || l.getName().equals("Milk"))
            text.append("And guess what, as the base is milk, it's even better than a normal smoothie. It's a milkshake!");
        return text.toString();
    }
}



