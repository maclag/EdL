import java.util.Random;
import java.util.Scanner;

public class HandlingExceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int value = sc.nextInt();
        System.out.println("Valor do usuário: " + value);

        Example c1 = new Example(value);

        try {
            int x = rand.nextInt(100);
            System.out.println("Valor de x: " + x);
            c1.f(x);
        } catch (Exception e) { // Não sabe exatamente qual erro poderá ser causado => é necessário executar o programa
            System.out.println(e);
        } finally {
            System.out.println("\nEnd of the f() method!");
        }

        sc.close();
    }
}