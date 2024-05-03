package calculator;

public enum OperatorType {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULUS('%');

    private final char c;

    OperatorType(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public static OperatorType getChar(char c) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.c == c) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("Unknown operator type: " + c);
    }
}