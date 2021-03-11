package at.fhj.iit;

public class Main {

    public static void main(String[] args){

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein",l);
        System.out.println(d);

        Liquid w= new Liquid("Water", 0.3, 0);
        System.out.println(w.getName());
        System.out.println(w.getVolume());
        Drink t = new Tea("Early Grey", w, false);
        System.out.println(t);
    }
}
