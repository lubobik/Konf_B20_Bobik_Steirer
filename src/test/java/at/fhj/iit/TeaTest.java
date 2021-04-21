package at.fhj.iit;
import at.fhj.iit.base.Liquid;
import at.fhj.iit.custom.Tea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains test cases for the Tea class
 * @author Lukas Bobik
 * @version 2.0
 * @see Tea
 */

@DisplayName("Testing Tea Class")
public class TeaTest {

    private Tea tea;

    //Setup
    @BeforeEach
    private void setup() {
        tea = new Tea("Test", new Liquid("testliquid", 0.5, 0), true, true);

    }

    /**
     * Tests toString
     */
    @Test
    @DisplayName("Testing toString")
    public void testToString() {
       Tea teaMilk = new Tea("Test", new Liquid("testliquid", 0.5, 0), false, true);
       Tea teaSugar = new Tea("Test", new Liquid("testliquid", 0.5, 0), true, false);
       Tea teaBoring = new Tea("Test", new Liquid("testliquid", 0.5, 0), false, false);
        assertEquals("This tea is from sort Test with sugar and milk", tea.toString());
        assertEquals("This tea is from sort Test with sugar", teaSugar.toString());
        assertEquals("This tea is from sort Test with milk", teaMilk.toString());
        assertEquals("This tea is from sort Test without milk or sugar", teaBoring.toString());
    }

    /**
     * Tests getMilk
     */
    @Test
    @DisplayName("Testing getMilk")
    public void testGetMilk() {
        assertTrue(tea.getMilk());
    }

    /**
     * Tests getSugar
     */
    @Test
    @DisplayName("Testing getSugar")
    public void testGetSugar() {
        assertTrue(tea.getSugar());
    }

    /**
     * Tests getVolume
     */
    @Test
    @DisplayName("Testing getVolume")
    public void testGetVolume() {
        assertEquals(0.5, tea.getVolume());
    }

    /**
     * Tests getAlcoholPercent
     */
    @Test
    @DisplayName("Testing getAlcoholPercent")
    public void testGetAlcoholPercent() {
        assertEquals(0, tea.getAlcoholPercent());
    }

    /**
     * Tests isAlcoholic
     */
    @Test
    @DisplayName("Testing isAlcoholic")
    public void testIsAlcoholic() {
        assertFalse(tea.isAlcoholic());
    }

}

