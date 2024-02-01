import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Vector<>();
        PostfixCalculator calculator = new PostfixCalculator(stack);

        System.out.println("Por favor ingrese el nombre del archivo de expresiones:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(fileName+".txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                int result = calculator.evaluatePostfix(line);
                System.out.println("Expresión: " + line + ", Resultado: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}