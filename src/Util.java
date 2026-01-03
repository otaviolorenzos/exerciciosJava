import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    public static int lerInteiroValido(Scanner sc, String mensagem) { // para todos as entradas inteiras
        int numeroLido = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(mensagem);
            try {
                numeroLido = sc.nextInt(); // nextInt só aceita entradas de num inteiro, por si só já é validação.
                entradaValida = true;
            }
            catch (InputMismatchException e) {
                System.out.println("⚠️ Erro! Por favor, digite apenas números inteiros.");
                sc.nextLine();
            }
        }
        sc.nextLine(); // Bug do Buffer
        return numeroLido;
    }

    public static String lerStringValida(Scanner sc, String mensagem) {
        String entrada = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println(mensagem);
            entrada = sc.nextLine().trim(); // .trim() remove espaços em branco inúteis

            if (entrada.isEmpty()) {
                System.out.println("⚠️ Erro! O campo não pode ficar vazio.");
            } else {
                entradaValida = true;
            }
        }
        return entrada;
    }

    public static double lerDoubleValido(Scanner sc, String mensagem) {
        double numeroLido = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println(mensagem);
            try {
                numeroLido = sc.nextDouble();
                if (numeroLido < 0) {
                    System.out.println("⚠️ Erro! O valor não pode ser negativo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Erro! Digite um número decimal válido (Ex: 10,50 ou 10.50).");
                sc.nextLine(); // Limpa o erro do buffer
            }
        }
        return numeroLido;
    }
}

