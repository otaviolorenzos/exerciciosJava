public class sitemaDeVendas {


    public static void main(String[] args) {
        String[] produtos = {"Mouse", "Teclado", "Monitor", "Webcam", "Headset"};
        Double[] precoProdutos = {29.9, 79.5, 899.2, 137.45, 119.9};
        int [] estoqueProdutos = {5, 7, 9, 4, 8};

        for (int i = 0; i<produtos.length; i++) {
            System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)", i+1, produtos[i], precoProdutos[i], estoqueProdutos[i]));
        }

    }

}
