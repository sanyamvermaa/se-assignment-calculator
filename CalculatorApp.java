public class CalculatorApp {
    
    public String calculate(String op, double num1, double num2) {
        double result = 0;
        switch (op.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if (num2 == 0) return "Error: Cannot divide by zero";
                result = num1 / num2;
                break;
            default:
                return "Error: Invalid Operation";
        }
        return "Result: " + result;
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();

        if (args.length < 3) {
            System.out.println("Usage: java CalculatorApp [add|sub|mul|div] <num1> <num2>");
            return;
        }

        try {
            String op = args[0];
            double num1 = Double.parseDouble(args[1]);
            double num2 = Double.parseDouble(args[2]);
            System.out.println(app.calculate(op, num1, num2));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid numbers.");
        }
    }
}