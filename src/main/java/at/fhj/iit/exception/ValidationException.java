package at.fhj.iit.exception;

/**
 * Just a wrapper / nice-to-have class.
 * Further specifies an IllegalArgumentException.
 * <p>
 * Should be used when an important validation failed
 * (eg. constructor arguments are illegal).
 *
 * @author Andreas Steirer
 * @version 2.0
 * @see IllegalArgumentException
 */
public class ValidationException extends IllegalArgumentException {
    public ValidationException(String message) {
        super(message);
    }
}
