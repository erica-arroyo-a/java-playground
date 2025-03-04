import java.util.*;

class ExcelSheet {
    private Map<String, String> cells;

    public ExcelSheet() {
        cells = new HashMap<>();
    }

    // Set a cell with a value or formula
    public void set(String cell, String value) {
        cells.put(cell, value);
    }

    // Reset a cell
    public void reset(String cell) {
        cells.remove(cell);
    }

    // Evaluate the value of a cell
    private int evaluate(String value) {
        if (value.startsWith("=")) {
            return evaluateExpression(value.substring(1));
        } else {
            return Integer.parseInt(value);
        }
    }

    // Evaluate an expression
    private int evaluateExpression(String expression) {
        String[] tokens = expression.split("(?=[-+])|(?<=[-+])");
        int result = 0;
        int sign = 1;

        for (String token : tokens) {
            token = token.trim();
            if (token.equals("+")) {
                sign = 1;
            } else if (token.equals("-")) {
                sign = -1;
            } else {
                int value = isCellReference(token) ? evaluate(cells.getOrDefault(token, "0")) : Integer.parseInt(token);
                result += sign * value;
            }
        }
        return result;
    }

    // Check if a token is a cell reference
    private boolean isCellReference(String token) {
        return token.matches("[A-Z]+[0-9]+");
    }

    // Print all cells with their raw and computed values
    public void print() {
        for (Map.Entry<String, String> entry : cells.entrySet()) {
            String cell = entry.getKey();
            String rawValue = entry.getValue();
            int computedValue = evaluate(rawValue);
            System.out.println(cell + " -> Raw: " + rawValue + ", Computed: " + computedValue);
        }
    }

    public static void main(String[] args) {
        ExcelSheet sheet = new ExcelSheet();
        sheet.set("A1", "10");
        sheet.set("B2", "=9+10");
        sheet.set("C3", "=-1+-10+2");
        sheet.set("D4", "=A1+10");
        sheet.print();
    }
}
