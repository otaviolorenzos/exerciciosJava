import java.util.Scanner;

public class Aplicacao {

    public  static void main(String[] args) {
        System.out.println("Bem-Vindo(a) a OLS Sistemas");
        Scanner sc = new Scanner(System.in);
        Inventario i = new Inventario();

        int usuario = Util.lerInteiroValido (sc, "Deseja entrar como [1] Administrador ou [2] Cliente? ");
        if (usuario == 1) {
            System.out.println("O que deseja fazer? ");
            System.out.println("[1] Cadastrar novo produto | [2] Aplicar cupom de Desconto em produto existente");
            int oqueFazer = Util.lerInteiroValido(sc, "Escolha uma opção: ");
            if (oqueFazer == 1) {
                boolean continuarCadastrando = true;
                while (continuarCadastrando) {
                    System.out.println("Vamos cadastrar um novo produto!");
                    System.out.println("Qual tipo de produto deseja cadastrar?");
                    System.out.println("[1] Comum | [2] Importado | [3] Promoção");
                    int tipo = Util.lerInteiroValido(sc, "Escolha uma opção: ");
                    String nomeDoProduto = Util.lerStringValida(sc, "Qual o nome do Produto? ");
                    Double precoDoProduto = Util.lerDoubleValido(sc, "Qual o preço para o Produto? ");
                    int estoqueDoProduto = Util.lerInteiroValido(sc, "Qual a quantidade do Produto disponível? ");
                    i.cadastrarNovoProduto(nomeDoProduto, precoDoProduto, estoqueDoProduto, tipo);
                    boolean numValidoContinuarCadastrando = false;
                    int resposta = 0;
                    while (!numValidoContinuarCadastrando) {
                        resposta = Util.lerInteiroValido(sc, "Deseja cadastrar mais Produtos? [1-SIM /2-Não]");
                        numValidoContinuarCadastrando = Inventario.isRespostaValida(resposta);
                        if (resposta == 2) {
                            continuarCadastrando = false;
                            numValidoContinuarCadastrando = true;
                        } else if (resposta == 1) {
                            numValidoContinuarCadastrando = true;
                        }
                    }
                }
            } else if (oqueFazer == 2) {
                i.ExibirInventario();
                int indice = Util.lerInteiroValido(sc, "Em qual dos produtos você gostaria de incluir um cupom de desconto? ");
                double porcentagem = Util.lerDoubleValido(sc, "Qual a porcentagem de desconto do Cupom? ");
                i.aplicarDescontoEspecial(indice, porcentagem);
            }
        }


        boolean continuarComprando = true;
        while (continuarComprando) {
            int itemAComprar = 0;
            boolean numValidoProduto = false;
            int unidades = 0;
            while (!numValidoProduto) {
                i.ExibirInventario();
                itemAComprar = Util.lerInteiroValido(sc,
                        "Escolha qual item deseja comprar: [nº do item]: "); // analisa se é inteiro
                numValidoProduto = i.AnalisarSeExisteP(itemAComprar); // analisa se esta fora do intervalo de produtos
            }
            boolean numValidoEstoque = true;
            while (numValidoEstoque) {
                System.out.println("Temos " + i.getEstoqueDoProdutoNoIndice(itemAComprar) +
                        " unidades disponiveis de " +
                        i.getNomeDoProdutoNoIndice(itemAComprar));
                unidades = Util.lerInteiroValido(sc, "Quantas unidades você gostaria?"); // analisa se é inteiro
                numValidoEstoque = i.VerificarEstoque(unidades, itemAComprar);
            }
            i.AddAoCarrinho(itemAComprar, unidades);
            System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, i.getNomeDoProdutoNoIndice(itemAComprar)));
            System.out.println("Valor total: R$" + i.getValorNoCarrinho());

            boolean numValidoResposta = false;
            int resposta = 0;
            while (!numValidoResposta) {
                resposta = Util.lerInteiroValido(sc, "Deseja continuar comprando? [1-SIM /2-Não]");
                numValidoResposta = Inventario.isRespostaValida(resposta);
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
                pago = i.avaliarQualPagamento(opcao);
            }
                double carrinhoInicial = i.getValorNoCarrinho();
                double carrinhoAlterado = i.calcularPagamento(opcao, i.getValorNoCarrinho());
                System.out.println("Valor do carrinho: R$" + i.getValorNoCarrinho());
                System.out.println("Total com a alteração escolhida aplicada: R$"+ carrinhoAlterado);
                pago = true;
            System.out.println("Você receberá um e-mail com as instruções de pagamento.");
            System.out.println("Muito obrigado por comprar na OLS Sistemas!");
        }
    };