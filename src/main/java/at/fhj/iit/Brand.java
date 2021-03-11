package at.fhj.iit;

public enum Brand {
    COCA_COLA("Coca Cola"),
    LA_CROIX("La Croix"),
    PEPSI("Pepsi"),
    NESQUIK("Nesquik"),
    OTHER("Other"),
    ;

    private final String name;

    Brand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
