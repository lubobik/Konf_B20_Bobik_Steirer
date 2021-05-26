package at.fhj.iit.custom.cashRegister;

import at.fhj.iit.base.Liquid;
import at.fhj.iit.base.SimpleDrink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Contains test cases regarding the
 * <code>DrinkSale</code> class and its
 * corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see DrinkSale
 */
@DisplayName("Testing DrinkSale class")
public class DrinkSaleTests {
    @Test
    @DisplayName("Testing init and retrieval of DrinkSale values")
    public void initAndRetrieveSaleValues() {
        // Phase: Setup
        Operator operator = new Operator("Jon", "Doe");
        DrinkSale drinkSale = new DrinkSale(
                new SimpleDrink(
                        "TestDrink",
                        new Liquid("TestLiquid", 12.23, 12.09)
                ), operator);

        // Phases: Verify(Exercise)
        assertTrue(drinkSale.getDrink().isAlcoholic());
        assertEquals(13.71, drinkSale.getPrice());
        assertEquals(12.23, drinkSale.getDrink().getVolume());
        assertEquals(12.09, drinkSale.getDrink().getAlcoholPercent());
        assertEquals(operator.getFullName(), drinkSale.getOperator().getFullName());
        assertEquals(
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                drinkSale.getSoldAt().truncatedTo(ChronoUnit.SECONDS)
        );
    }
}
