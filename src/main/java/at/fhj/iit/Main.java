package at.fhj.iit;

public class Main {

    public static void main(String[] args){

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein",l);
        System.out.println(d);

        System.out.println("-".repeat(80));
        System.out.println("END OF ALREADY SPECIFIED CODE");
        System.out.println("-".repeat(80));

        SoftDrink softDrink = new SoftDrink("Orange juice", 0.5, Brand.COCA_COLA);
        System.out.println(softDrink);

        Liquid w= new Liquid("Water", 0.3, 0);
        System.out.println(w.getName());
        System.out.println(w.getVolume());
        Drink t = new Tea("Early Grey", w, false);
        System.out.println(t);
    }
}
