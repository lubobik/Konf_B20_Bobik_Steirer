package at.fhj.iit.custom;

public class Fruit {
    private String name;

    /**
     * Creates new fruit
     *
     * @param name name of liquid
     */
    public Fruit(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     *
     * @return name of fruit
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name fruitname
     */
    public void setName(String name) {
        this.name = name;
    }
}
