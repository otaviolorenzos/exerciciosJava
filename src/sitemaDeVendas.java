import java.util.InputMismatchException;
import java.util.Scanner;

public class sitemaDeVendas {


    public static void main(String[] args) {
        String[] produtos = {"Mouse", "Teclado", "Monitor", "Webcam", "Headset"};
        Double[] precoProdutos = {29.9, 79.5, 899.2, 137.45, 119.9};
        int [] estoqueProdutos = {5, 7, 9, 4, 8};
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-Vindo{a) a loja de Informática da OLS Sistemas. Nossos itens disponiveis são: ");


        Double carrinho = 0.0;
        boolean continuarComprando = true;
        while (continuarComprando) {
            try {
                for (int i = 0; i<produtos.length; i++) {
                    System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)", i+1, produtos[i], precoProdutos[i], estoqueProdutos[i]));
                }
                System.out.println("----Qual item você deseja comprar? escolha de acordo com o nº dentro de []----:");
                int itemComprar = sc.nextInt();

                if (itemComprar > 0 && itemComprar < 6) {
                    System.out.println("Perfeito, temos " + estoqueProdutos[itemComprar-1] + " unidades disponiveis de " + produtos[itemComprar-1]);
                    System.out.println("Quantas unidades você gostaria?");
                    int unidades = sc.nextInt();
                    if (unidades > 0 && unidades < estoqueProdutos[itemComprar-1]) {
                        carrinho = carrinho + (precoProdutos[itemComprar-1]*unidades);
                        System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, produtos[itemComprar-1]));
                        System.out.println(String.format("Valor total: R$%.2f", carrinho));
                    } else {
                        System.out.println("Não temos esta quantidade disponivel, tente novamente.");
                    }
                    boolean resposta1 = true;
                    int resposta = 0;
                    while (resposta1) {
                        System.out.println("Deseja continuar comprando? [1-SIM /2-Não]");
                        resposta = sc.nextInt();
                        if (resposta == 2) {
                            continuarComprando = false;
                            resposta1 = false;
                        } else if (resposta == 1) {
                            break;
                        } else {
                            System.out.println("Número inválido, escolha [1] para SIM e [2] para Não: ");
                            sc.next();
                        }
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um ídice entre 1 e 5");
                sc.next();
            }
        }



    }

}
