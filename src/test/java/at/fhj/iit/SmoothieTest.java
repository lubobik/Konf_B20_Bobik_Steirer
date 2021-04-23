package at.fhj.iit;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.misc.Fruit;
import at.fhj.iit.custom.drink.Smoothie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the Smoothie class
 * @author Lukas Bobik
 * @version 2.0
 * @see Smoothie
 * @since 2.0
 */

@DisplayName("Testing Smoothie Class")
public class SmoothieTest {

    private Smoothie smoothie;

    /**
     * Setup
     */
    @BeforeEach
    private void setup() {
        smoothie = new Smoothie("Milkshake", new Liquid("testliquid", 1, 0), List.of(new Fruit("test1"), new Fruit("test2")), false);
    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
        Smoothie smoothiemilk = new Smoothie("Milkshake", new Liquid("milk", 1, 0), List.of(new Fruit("test1"), new Fruit("test2")), false);
        assertEquals("Here, have a nice Smoothie, it's a mix from milk and test1, test2.And guess what, as the base is milk, it's even better than a normal smoothie. It's a milkshake!", smoothiemilk.toString());
        assertEquals("Here, have a nice Smoothie, it's a mix from testliquid and test1, test2.", smoothie.toString());
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void testGetVolume() {
        assertEquals(1, smoothie.getVolume());
    }
    /**
     * Tests getAlcoholPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void testGetAlcoholPercent() {
       assertEquals(0,smoothie.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void testIsAlcoholic() {
        assertFalse(smoothie.isAlcoholic());
    }


}

