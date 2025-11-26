import java.util.Scanner;

public class VersaoDois {
    public  static void main(String[] args) {
        System.out.println("Bem-Vindo(a) a OLS Sistemas");
        Produtos p = new Produtos();

        boolean continuarComprando = true;
        while (continuarComprando){
            p.ExibirInventario();
            System.out.println("Escolha qual item deseja comprar: [nº do item]: "); // não repete caso seja fora do intervalo
            Scanner sc = new Scanner(System.in);
            int itemAComprar = sc.nextInt();
            try {
                p.AnalisarSeExisteP(itemAComprar);
                System.out.println("Perfeito, temos " + p.estoqueProdutos[itemAComprar-1] + " unidades disponiveis de " + p.produtos[itemAComprar-1]);
                System.out.println("Quantas unidades você gostaria?");
                int unidades = sc.nextInt();
                try {
                    p.VerificarEstoque(unidades, itemAComprar); // tmb não repete caso intervalo esteja fora
                    p.AddAoCarrinho(itemAComprar, unidades, p);
                    System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, p.produtos[itemAComprar-1]));
                    System.out.println("Valor total: R$" + p.valorNoCarrinho);
                }
                catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
            }
            catch (RuntimeException e){
            System.out.println(e.getMessage());
            sc.next();
            }

            int resposta = 0;
            boolean r = false;
            while (!r) {
                try {
                    System.out.println("Deseja continuar comprando? [1-SIM /2-Não]");
                    resposta = sc.nextInt();
                    r = Produtos.respotaContinuarComprando(resposta);
                    if (resposta == 2){
                        continuarComprando = false;
                        r = true;
                    } else if (resposta == 1) {
                        r = true;
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }

            boolean pago = false;
            while (!pago) {
                System.out.println("Qual o método de pagamento? ");
                System.out.println("[1] - PIX/DÉBITO >> 10% de Desconto.");
                System.out.println("[2] - CRÉDITO");
                System.out.println("[3] - BOLETO >> 5% de Acréscimo");
                System.out.println("Escolha um nº entre []: ");
                int opcao = sc.nextInt();
                System.out.println("Valor do carrinho: R$" + p.valorNoCarrinho);
                double carrinhoInicial = p.valorNoCarrinho;
                try {
                    double carrinhoAlterado = p.calcularPagamento(opcao, p.valorNoCarrinho);
                    System.out.println("Total com a alteração escolhida aplicada: R$" + carrinhoAlterado);
                    pago = true;
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Você receberá um e-mail com as instruções de pagamento.");
            System.out.println("Muito obrigado por comprar na OLS Sistemas!");
        }
    }
}