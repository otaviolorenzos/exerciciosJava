import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaDeVendas {


    public static void main(String[] args) {
        String[] produtos = {"Mouse", "Teclado", "Monitor", "Webcam", "Headset"};
        Double[] precosProdutos = {29.9, 79.5, 899.2, 137.45, 119.9};
        int [] estoqueProdutos = {5, 7, 9, 4, 8};
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-Vindo{a) a loja de Informática da OLS Sistemas. Nossos itens disponiveis são: ");


        Double carrinho = 0.0;
        boolean continuarComprando = true;
        while (continuarComprando) {
            try {
                for (int i = 0; i<produtos.length; i++) {
                    System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)", i+1, produtos[i], precosProdutos[i], estoqueProdutos[i]));
                }

                System.out.println("----Qual item você deseja comprar? escolha de acordo com o nº dentro de []----:");
                int itemAComprar = sc.nextInt();

                if (itemAComprar > 0 && itemAComprar < 6) {
                    System.out.println("Perfeito, temos " + estoqueProdutos[itemAComprar-1] + " unidades disponiveis de " + produtos[itemAComprar-1]);
                    System.out.println("Quantas unidades você gostaria?");
                    int unidades = sc.nextInt();
                    if (unidades > 0 && unidades < estoqueProdutos[itemAComprar-1]) {
                        carrinho = carrinho + (precosProdutos[itemAComprar-1]*unidades);
                        System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, produtos[itemAComprar-1]));
                        System.out.println(String.format("Valor total: R$%.2f", carrinho));
                        estoqueProdutos[itemAComprar-1] = estoqueProdutos[itemAComprar-1] - unidades;
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
        boolean pago = false;
        while (!pago) {
            try {
                int pagamento = 0;
                Double carrinhoAlterado = 0.0;
                System.out.println("Qual o método de pagamento? ");
                System.out.println("[1] - PIX/DÉBITO >> 10% de Desconto.");
                System.out.println("[2] - CRÉDITO");
                System.out.println("[3] - BOLETO >> 5% de Acréscimo");
                System.out.println("Escolha um nº entre []: ");
                pagamento = sc.nextInt();
                System.out.println("Valor do carrinho: R$" + carrinho);
                switch (pagamento) {
                    case 1: //10%
                        double desconto = carrinho * 0.1;
                        carrinhoAlterado = carrinho - desconto;
                        System.out.println("Total de desconto (10%): R$"+ desconto);
                        System.out.println("Total com o desconto aplicado: R$"+ carrinhoAlterado);
                        pago = true;
                        break;
                    case 2: // sem desconto
                        System.out.println("Valor final é o mesmo.");
                        pago = true;
                        break;
                    case 3: // 5%+
                        double acrescimo = carrinho * 0.05;
                        carrinhoAlterado = carrinho + acrescimo;
                        System.out.println("Total de acréscimo (5%): R$"+ acrescimo);
                        System.out.println("Total com o acréscimo aplicado: R$"+ carrinhoAlterado);
                        pago = true;
                        break;
                    default:
                        System.out.println("Método inválido, Por favor: digite um índice entre 1 e 3");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um ídice entre 1 e 3");
                sc.next();
            }

        }
        System.out.println("Você receberá um e-mail com as instruções de pagamento.");
        System.out.println("Muito obrigado por comprar da OLS Sistemas!");
    }

}
