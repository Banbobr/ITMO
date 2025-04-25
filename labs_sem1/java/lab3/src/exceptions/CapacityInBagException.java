package exceptions;

public class CapacityInBagException extends RuntimeException {
    public CapacityInBagException(String message) {
        super(message);
    }
}