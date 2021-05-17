package at.fhj.iit.custom.misc;

public class Fruit {
    private String name;

    /**
     * Creates new fruit
     *
     * @param name name of fruit
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
     * @param name fruit name
     */
    public void setName(String name) {
        this.name = name;
    }
}
