package at.fhj.iit.custom;

/**
 * Specifies a <code>Brand</code> enumeration with an
 * also fixed name specification.
 *
 * @author Andreas Steirer
 * @version 2.0
 * @since 1.0
 */
public enum Brand {
    COCA_COLA("Coca Cola"),
    LA_CROIX("La Croix"),
    PEPSI("Pepsi"),
    NESQUIK("Nesquik"),
    OTHER("Other"),
    ;

    /*
     * The specified name
     */
    private final String name;

    Brand(String name) {
        this.name = name;
    }

    /**
     * Output of a stringified <code>Brand</code> enum value
     */
    @Override
    public String toString() {
        return name;
    }
}
