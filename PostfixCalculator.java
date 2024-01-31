public class PostfixCalculator {
    private Stack<Integer> stack;

    public PostfixCalculator(Stack<Integer> stack) {
        this.stack = stack;
    }

    public int evaluatePostfix(String expression) {
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador Invalido: " + token);
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
