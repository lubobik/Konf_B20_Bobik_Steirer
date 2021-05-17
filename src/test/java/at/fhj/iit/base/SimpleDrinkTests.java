package at.fhj.iit.base;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains test cases for the <code>SimpleDrink</code> class
 *
 * @author Lukas Bobik
 * @version 2.0
 * @see SimpleDrink
 */
@DisplayName("Testing SimpleDrink class")
class SimpleDrinkTests {
    private SimpleDrink drink;

    /**
     * Setup
     */
    @BeforeEach
    private void setup() {
        drink = new SimpleDrink("test", new Liquid("water", 1, 0.1));
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void getVolume() {
        assertEquals(1, drink.getVolume());
    }

    /**
     * Tests getAlcoholicPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void getAlcoholPercent() {
        assertEquals(0.1, drink.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void isAlcoholic() {
        assertTrue(drink.isAlcoholic());
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        assertEquals("Simple Drink called test with 0.1 percent alcohol by volume", drink.toString());
    }
}