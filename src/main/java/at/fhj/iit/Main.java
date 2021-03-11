package at.fhj.iit;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein", l);
        System.out.println(d);

        printSeparator();
        System.out.println("END OF ALREADY SPECIFIED CODE");
        printSeparator();

        SoftDrink softDrink = new SoftDrink("Orange juice", 0.5, Brand.COCA_COLA);
        System.out.println(softDrink);

        printSeparator();

        Liquid w = new Liquid("Water", 0.3, 0);
        Drink t = new Tea("Early Grey", w, true, true);
        System.out.println(t);

        printSeparator();

        List<Liquid> maiTaiLiquids = List.of(
                new Liquid("Rum", 2.0, 40.0),
                new Liquid("Cointreau", 0.5, 35.0),
                new Liquid("Orgeat Syrup", 0.5, 0.0),
                new Liquid("Lime Juice", 0.5, 0.0),
                new Liquid("Water", 2, 0.0)
        );
        Cocktail maiTai = new Cocktail("Mai Tai", maiTaiLiquids);
        System.out.println(maiTai);
    }

    private static void printSeparator() {
        System.out.println("-".repeat(80));
    }
}
