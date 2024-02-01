import org.junit.Test;
import static org.junit.Assert.*;

public class TestPostfix {

    @Test
    public void testEvaluatePostfix() {
        Stack<Integer> stack = new Vector<>();
        PostfixCalculator calculator = new PostfixCalculator(stack);

        String expression = "1 2 + 4 * 3 +";
        int result = calculator.evaluatePostfix(expression);
        assertEquals(15, result);
    }

    @Test
    public void testAnotherExpression() {
        Stack<Integer> stack = new Vector<>();
        PostfixCalculator calculator = new PostfixCalculator(stack);

        
        String expression = "2 3 * 4 +";
        int result = calculator.evaluatePostfix(expression);
        assertEquals(10, result);
    }
}