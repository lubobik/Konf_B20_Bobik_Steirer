package at.fhj.iit;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.drink.LongDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains test cases for the <code>LongDrink</code> class
 *
 * @author Lukas Bobik
 * @version 2.0
 * @see LongDrink
 * @since 2.0
 */
@DisplayName("Testing LongDrink class")
class LongDrinkTest {
    private LongDrink longDrink;

    /**
     * Setup
     */
    @BeforeEach
    private void setup() {
        longDrink = new LongDrink("testdrink", new Liquid("testliquid", 0.5, 20), new Liquid("testjuice", 0.3, 0));
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void getVolume() {
        assertEquals(0.8, longDrink.getVolume());
    }

    /**
     * Tests getAlcoholicPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void getAlcoholPercent() {
        assertEquals(12.5, longDrink.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void isAlcoholic() {
        assertTrue(longDrink.isAlcoholic());
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        assertEquals("testdrink like the name suggests is testliquid and testjuice with an alcohol percentage of 12.5%.", longDrink.toString());
    }
}