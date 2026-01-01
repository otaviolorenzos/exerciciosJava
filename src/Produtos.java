import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Produtos {
    private ArrayList<String> produtos = new ArrayList<>(); // uma lista que não tem tamanho fixo
    private ArrayList<Double> precosProdutos = new ArrayList<>();
    private ArrayList<Integer> estoqueProdutos = new ArrayList<>();
    private Double valorNoCarrinho = 0.0;

    public Produtos () {
        this.produtos.add("Mouse");
        this.precosProdutos.add(29.9);
        this.estoqueProdutos.add(5);

        this.produtos.add("Teclado");
        this.precosProdutos.add(79.5);
        this.estoqueProdutos.add(7);

        this.produtos.add("Monitor");
        this.precosProdutos.add(899.2);
        this.estoqueProdutos.add(9);

        this.produtos.add("Webcam");
        this.precosProdutos.add(137.45);
        this.estoqueProdutos.add(4);

        this.produtos.add("Headset");
        this.precosProdutos.add(119.9);
        this.estoqueProdutos.add(8);

    }

    public double getValorNoCarrinho() {
        return this.valorNoCarrinho;
    }
    public ArrayList<Integer> getEtoqueProdutos() {
        return this.estoqueProdutos;
    }

    public ArrayList<Double> getPrecosProdutos() {
        return this.precosProdutos;
    }

    public String getNomeProdutoIndividual(int indice) {
        return this.produtos.get(indice - 1);
    }


    public int getEstoqueIndividual(int indice) {
        return this.estoqueProdutos.get(indice - 1);
    }


    public void ExibirInventario() {
        System.out.println("------------- PRODUTOS -------------");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)",
                    i + 1,
                    produtos.get(i),
                    precosProdutos.get(i),
                    estoqueProdutos.get(i)));
        }
        System.out.println("------------- PRODUTOS -------------");
    }

    public boolean AnalisarSeExisteP(int itemAComprar){  //Analisa de está fora do intervalo de produtos
        if (itemAComprar <= 0 || itemAComprar > produtos.size()) {
            System.out.println("Número Inválido, tente novamente.");
            return false;
        } return true;
    }

    public boolean VerificarEstoque(int unidades, int itemAComprar){
        if (unidades > estoqueProdutos.get(itemAComprar-1)){
            System.out.println("Estoque indisponível para quantidade desejada, tente novamente.");
            return true;
        } else if (unidades <= 0){
            System.out.println("Número inválido, tente novamente.");
            return true;
        }
        return false;
    }

    public Double AddAoCarrinho(int itemAComprar, int unidades){
        this.valorNoCarrinho = this.valorNoCarrinho + (this.precosProdutos.get(itemAComprar-1)*unidades);
        int estoqueAtual = this.estoqueProdutos.get(itemAComprar-1);
        int estoqueAtualizado = estoqueAtual - unidades;
        this.estoqueProdutos.set(itemAComprar-1, estoqueAtualizado);
        return valorNoCarrinho;
    }

    public  static boolean isRespostaValida (int resposta) {
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
