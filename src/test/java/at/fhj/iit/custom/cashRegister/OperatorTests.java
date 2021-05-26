package at.fhj.iit.custom.cashRegister;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Contains test cases regarding the
 * <code>Operator</code>
 * class and its corresponding implementations.
 *
 * @author Andreas Steirer
 * @version 3.0
 * @see Operator
 */
public class OperatorTests {
    @Test
    @DisplayName("Testing init and retrieval of full name")
    public void initAndCheckOperatorName() {
        Operator operator = new Operator("Jon", "Doe");

        assertNotNull(operator);
        assertEquals("Jon Doe", operator.getFullName());
    }
}
