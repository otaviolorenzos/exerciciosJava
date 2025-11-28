import java.util.InputMismatchException;
import java.util.Scanner;

public class Produtos {
    private String[] produtos = {"Mouse", "Teclado", "Monitor", "Webcam", "Headset"};
    private Double[] precosProdutos = {29.9, 79.5, 899.2, 137.45, 119.9};
    private int[] estoqueProdutos = {5, 7, 9, 4, 8};
    private Double valorNoCarrinho = 0.0;

    public double getValorNoCarrinho() {
        return this.valorNoCarrinho;
    }
    public int[] getEtoqueProdutos() {
        return this.estoqueProdutos;
    }
    public Double[] getPrecosProdutos() {
        return this.precosProdutos;
    }
    public String [] getProdutos (){
        return  this.produtos;
    }


    public void ExibirInventario() {
        System.out.println("------------- PRODUTOS -------------");
        for (int i = 0; i < produtos.length; i++) {
            System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)", i + 1, produtos[i], precosProdutos[i], estoqueProdutos[i]));
        }
        System.out.println("------------- PRODUTOS -------------");
    }

    public boolean AnalisarSeExisteP(int itemAComprar){  //Analisa de está fora do intervalo de produtos
        if (itemAComprar <= 0 || itemAComprar > produtos.length) {
            System.out.println("Número Inválido, tente novamente.");
            return false;
        } return true;
    }

    public boolean VerificarEstoque(int unidades, int itemAComprar){
        if (unidades > estoqueProdutos[itemAComprar-1]){
            System.out.println("Estoque indisponível para quantidade desejada, tente novamente.");
            return true;
        } else if (unidades < 0){
            System.out.println("Número inválido, tente novamente.");
            return true;
        }
        return false;
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
            System.out.println("Número Inválido, tente novamente.");
            return true;
        }
    }

    public double calcularPagamento (int opcao, double valorNoCarrinho) {
            if (opcao == 1) {
                valorNoCarrinho = valorNoCarrinho - (valorNoCarrinho * 0.1);
            } else if (opcao == 2){
                System.out.println("Sem Alterações.");
            } else if (opcao == 3) {
                valorNoCarrinho = valorNoCarrinho + (valorNoCarrinho * 0.05);
            } else {
                System.out.println("Número Inválido, tente novamente.");
            }

        return valorNoCarrinho;
    }

    public  boolean  avaliarQualPagamento (int opcao){
        if (opcao < 1 || opcao > 3) {
            System.out.println("Número Inválido, tente novamente.");
            return false;
        } return true;
    }



}
