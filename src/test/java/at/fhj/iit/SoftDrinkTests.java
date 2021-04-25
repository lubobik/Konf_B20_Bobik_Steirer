package at.fhj.iit;

import at.fhj.iit.custom.misc.Brand;
import at.fhj.iit.custom.misc.SoftDrink;
import at.fhj.iit.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Contains test cases regarding the
 * <code>SoftDrink</code> class and its implementations.
 *
 * @author Andreas Steirer
 * @version 2.0
 * @see SoftDrink
 */
@DisplayName("Testing SoftDrink class")
public class SoftDrinkTests {

    private SoftDrink softDrink;

    /*
     * Phase: Setup
     */
    @BeforeEach
    private void setup() {
        softDrink = new SoftDrink("TestDrink", 12.45, Brand.NESQUIK);
    }

    // More or less important to test.
    // Normally this is not tested separately.
    @Test
    @DisplayName("Testing change of name")
    public void changeName() {
        // Phases: Exercise
        String newName = "NewTestDrink";
        softDrink.setName(newName);

        // Phases: Verify
        assertEquals(newName, softDrink.getName());
    }

    // More or less important to test.
    // Normally this is not tested separately.
    @Test
    @DisplayName("Testing change of volume")
    public void changeVolume() {
        // Phases: Exercise
        double newVolume = 10.0;
        softDrink.setVolume(newVolume);

        // Phases: Verify
        assertEquals(newVolume, softDrink.getVolume());
    }

    // More or less important to test.
    // Normally this is not tested separately.
    @Test
    @DisplayName("Testing change of Brand")
    public void changeBrand() {
        // Phases: Exercise
        Brand newBrand = Brand.LA_CROIX;
        softDrink.setBrand(newBrand);

        // Phases: Verify
        assertEquals(newBrand, softDrink.getBrand());
    }

    @Test
    @DisplayName("Testing fails at SoftDrink creation")
    public void createInvalidSoftDrink() {
        // Phases: Verify(Exception specification, Exercise)
        assertThrows(
                ValidationException.class,
                () -> new SoftDrink("CheckerDrink", 0.0, Brand.OTHER)
        );
    }

    // More or less important to test.
    // Normally this is very rarely tested separately.
    @Test
    @DisplayName("Testing toString implementation")
    public void callToString() {
        // Phases: Verify(Exercise)
        assertEquals(
                "The SoftDrink 'TestDrink' is manufactured by 'Nesquik' and got a standard volume of 12.45 liters.",
                softDrink.toString()
        );
    }
}
