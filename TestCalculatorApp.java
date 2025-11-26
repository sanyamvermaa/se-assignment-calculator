public class TestCalculatorApp {
    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();

        // Test Case: Addition
        String result = app.calculate("add", 5, 3);
        
        // Validation
        if (!result.contains("8.0")) {
            throw new RuntimeException("Test Failed: 5 + 3 did not equal 8.0");
        }

        System.out.println("All Tests Passed!");
    }
}