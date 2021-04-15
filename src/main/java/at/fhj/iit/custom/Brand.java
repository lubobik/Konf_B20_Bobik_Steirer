package at.fhj.iit.custom;

public enum Brand {
    COCA_COLA("Coca Cola"),
    LA_CROIX("La Croix"),
    PEPSI("Pepsi"),
    NESQUIK("Nesquik"),
    OTHER("Other"),
    ;

    private final String title;

    Brand(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
