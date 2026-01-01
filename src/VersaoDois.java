import java.util.Scanner;
import java.util.ArrayList;

public class VersaoDois {

    public  static void main(String[] args) {
        System.out.println("Bem-Vindo(a) a OLS Sistemas");
        Produtos p = new Produtos();
        Scanner sc = new Scanner(System.in);

        boolean continuarComprando = true;
        while (continuarComprando) {
            int itemAComprar = 0;
            boolean numValidoProduto = false;
            int unidades = 0;
            while (!numValidoProduto) {
                p.ExibirInventario();
                itemAComprar = Util.lerInteiroValido(sc,
                        "Escolha qual item deseja comprar: [nº do item]: "); // analisa se é inteiro
                numValidoProduto = p.AnalisarSeExisteP(itemAComprar); // analisa se esta fora do intervalo de produtos
            }
            boolean numValidoEstoque = true;
            while (numValidoEstoque) {
                System.out.println("Temos " + p.getEstoqueIndividual(itemAComprar) +
                        " unidades disponiveis de " +
                        p.getNomeProdutoIndividual(itemAComprar));
                unidades = Util.lerInteiroValido(sc, "Quantas unidades você gostaria?"); // analisa se é inteiro
                numValidoEstoque = p.VerificarEstoque(unidades, itemAComprar);
            }
            p.AddAoCarrinho(itemAComprar, unidades);
            System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, p.getNomeProdutoIndividual(itemAComprar)));
            System.out.println("Valor total: R$" + p.getValorNoCarrinho());

            boolean numValidoResposta = false;
            int resposta = 0;
            while (!numValidoResposta) {
                resposta = Util.lerInteiroValido(sc, "Deseja continuar comprando? [1-SIM /2-Não]");
                numValidoResposta = Produtos.isRespostaValida(resposta);
                if (resposta == 2) {
                    continuarComprando = false;
                    numValidoResposta = true;
                } else if (resposta == 1) {
                    numValidoResposta = true;
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