package at.fhj.iit;

import at.fhj.iit.base.Liquid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the Liquid class
 * @author Lukas Bobik
 * @version 2.0
 * @see Liquid
 * @since 2.0
 */
class LiquidTest {
    private Liquid liquid;

    /**
     * Setup
     */
    @BeforeEach
    private void setup() {
        liquid=new Liquid("testliquid", 5, 5);
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void getVolume() {
        assertEquals(5,liquid.getVolume());
    }

    /**
     * Tests getAlcoholicPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void getAlcoholPercent() {
        assertEquals(5,liquid.getAlcoholPercent());
    }


    /**
     * Tests getName
     */
    @Test
    @DisplayName("Testing getName")
    void testGetName() {
        assertEquals("testliquid", liquid.getName());
    }

    /**
     * Tests setName
     */
    @Test
    @DisplayName("Testing setName")
    void testSetName() {
        String testname="test";
        liquid.setName(testname);
        assertEquals(testname, liquid.getName());
    }


    /**
     * Tests setVolume
     */
    @Test
    @DisplayName("Testing setVolume")
    void testSetVolume() {
        int test=7;
        liquid.setVolume(test);
        assertEquals(test, liquid.getVolume());
    }

    /**
     * Tests setAlcoholPercentage
     */
    @Test
    @DisplayName("Testing setAlcoholPercentage")
    void testSetAlcoholPercent() {
        int test=7;
        liquid.setAlcoholPercent(test);
        assertEquals(test, liquid.getAlcoholPercent());
    }


}