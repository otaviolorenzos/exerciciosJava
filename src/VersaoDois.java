import java.util.Scanner;

public class VersaoDois {

    public  static void main(String[] args) {
        System.out.println("Bem-Vindo(a) a OLS Sistemas");
        Produtos p = new Produtos();
        Scanner sc = new Scanner(System.in);

        boolean continuarComprando = true;
        while (continuarComprando) {
            int itemAComprar = 0;
            boolean numValido = false;
            int unidades = 0;
            while (!numValido) {
                p.ExibirInventario();
                itemAComprar = Util.lerInteiroValido(sc, "Escolha qual item deseja comprar: [nº do item]: "); // analisa se é inteiro
                numValido = p.AnalisarSeExisteP(itemAComprar); // analisa se esta fora do intervalo de produtos
            }
            while (numValido) {
                System.out.println("Temos " + p.getEtoqueProdutos()[itemAComprar - 1] + " unidades disponiveis de " + p.getProdutos()[itemAComprar - 1]);
                unidades = Util.lerInteiroValido(sc, "Quantas unidades você gostaria?"); // analisa se é inteiro
                numValido = p.VerificarEstoque(unidades, itemAComprar);
            }
            p.AddAoCarrinho(itemAComprar, unidades, p);
            System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, p.getProdutos()[itemAComprar - 1]));
            System.out.println("Valor total: R$" + p.getValorNoCarrinho());

            int resposta = 0;
            while (!numValido) {
                resposta = Util.lerInteiroValido(sc, "Deseja continuar comprando? [1-SIM /2-Não]");
                numValido = Produtos.respotaContinuarComprando(resposta);
                if (resposta == 2) {
                    continuarComprando = false;
                    numValido = true;
                } else if (resposta == 1) {
                    numValido = true;
                }
            }
        }
        boolean pago = false;
        int opcao = 0;
            while (!pago) {
                System.out.println("Qual o método de pagamento? ");
                System.out.println("[1] - PIX/DÉBITO >> 10% de Desconto.");
                System.out.println("[2] - CRÉDITO");
                System.out.println("[3] - BOLETO >> 5% de Acréscimo");
                opcao = Util.lerInteiroValido(sc, "Escolha um nº entre []: ");
                pago = p.avaliarQualPagamento(opcao);
            }
                double carrinhoInicial = p.getValorNoCarrinho();
                double carrinhoAlterado = p.calcularPagamento(opcao, p.getValorNoCarrinho());
                System.out.println("Valor do carrinho: R$" + p.getValorNoCarrinho());
                System.out.println("Total com a alteração escolhida aplicada: R$" + carrinhoAlterado);
                pago = true;
            System.out.println("Você receberá um e-mail com as instruções de pagamento.");
            System.out.println("Muito obrigado por comprar na OLS Sistemas!");
        }
    }