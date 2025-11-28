import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static int lerInteiroValido(Scanner sc, String mensagem) {
        int numeroLido = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(mensagem);
            try {
                numeroLido = sc.nextInt();
                entradaValida = true;
            }
            catch (InputMismatchException e) {
                System.out.println("⚠️ Erro! Por favor, digite apenas números inteiros.");
                sc.nextLine();
            }
        }
        return numeroLido;
    }
}

