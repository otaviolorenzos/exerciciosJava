public class ProdutoImportado extends Produto { // herança
    public ProdutoImportado(String nome, double preco, int estoque) {
        super(nome, preco, estoque); // Envia os dados para o construtor do Pai
    }

    public double getPrecoComTaxa() {
        // Usamos o getPreco() que já existe no pai e somamos 15%
        return getPreco() * 1.15;
    }
}