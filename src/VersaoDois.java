import java.util.Scanner;

public class VersaoDois {
    public  static void main(String[] args) {
        System.out.println("Bem-Vindo(a) a OLS Sistemas");
        Produtos p = new Produtos();

        boolean continuarComprando = true;

        while (continuarComprando){
            p.ExibirInventario();
            System.out.println("Escolha qual item deseja comprar: [nº do item]: ");
            Scanner sc = new Scanner(System.in);
            int itemAComprar = sc.nextInt();
            try {
                p.AnalisarSeExisteP(itemAComprar);
            }
            catch (RuntimeException e){
            System.out.println(e.getMessage());
            }

            System.out.println("Perfeito, temos " + p.estoqueProdutos[itemAComprar-1] + " unidades disponiveis de " + p.produtos[itemAComprar-1]);
            System.out.println("Quantas unidades você gostaria?");
            int unidades = sc.nextInt();
            try {
                p.VerificarEstoque(unidades, itemAComprar);
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
            p.AddAoCarrinho(itemAComprar, unidades, p);
            System.out.println(String.format("Adicionamos %d unidades de %s ao seu carrinho.", unidades, p.produtos[itemAComprar-1]));
            System.out.println("Valor total: R$" + p.valorNoCarrinho);

            int resposta = 0;
            System.out.println("Deseja continuar comprando? [1-SIM /2-Não]");
            resposta = sc.nextInt();
            if (resposta == 2){
                continuarComprando = false;
            }

        }
    }
}