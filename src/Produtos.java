public class Produtos {
    String[] produtos = {"Mouse", "Teclado", "Monitor", "Webcam", "Headset"};
    Double[] precosProdutos = {29.9, 79.5, 899.2, 137.45, 119.9};
    int[] estoqueProdutos = {5, 7, 9, 4, 8};
    Double valorNoCarrinho = 0.0;

    public void ExibirInventario() {
        System.out.println("------------- PRODUTOS -------------");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)", i + 1, produtos[i], precosProdutos[i], estoqueProdutos[i]));
        }
        System.out.println("------------- PRODUTOS -------------");
    }

    public int AnalisarSeExisteP(int itemAComprar){
        if (itemAComprar <= 0 || itemAComprar > produtos.length) {
            throw new RuntimeException("Número Inválido, tente novamente.");
        } return itemAComprar;
    }

    public boolean VerificarEstoque(int unidades, int itemAComprar){
        if (unidades > estoqueProdutos[itemAComprar-1]){
            throw new RuntimeException("Estoque indisponível para quantidade desejada, tente novamente.");
        } else if (unidades < 0){
            throw new RuntimeException("Número inválido, tente novamente.");
        }
        return true;
    }

    public Double AddAoCarrinho(int itemAComprar, int unidades, Produtos p){
        valorNoCarrinho = valorNoCarrinho + (p.precosProdutos[itemAComprar-1]*unidades);
        p.estoqueProdutos[itemAComprar-1] = p.estoqueProdutos[itemAComprar-1] - unidades;
        return valorNoCarrinho;
    }

    public  static boolean respotaContinuarComprando (int resposta) {
        if (resposta == 2) {
            return true;
        } else if (resposta == 1) {
            return false;
        } else {
            throw new RuntimeException("Número Inválido, tente novamente.");
        }
    }

    public double calcularPagamento (int opcao, double valorNoCarrinho) {
        switch (opcao) {
            case 1: //10%
                valorNoCarrinho =  valorNoCarrinho - (valorNoCarrinho * 0.1);
                break;
            case 2: // sem alteração
                break;
            case 3: // 5%+
                valorNoCarrinho = valorNoCarrinho + (valorNoCarrinho * 0.05);
                break;
            default:
                throw new RuntimeException("Número Inválido, tente novamente.");
        }
        return valorNoCarrinho;
    }
}
