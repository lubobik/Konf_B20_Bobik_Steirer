package at.fhj.iit;

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
    }

    private static void printSeparator() {
        System.out.println("-".repeat(80));
    }
}
