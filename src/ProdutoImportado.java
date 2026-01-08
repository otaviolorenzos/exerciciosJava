public class ProdutoImportado extends Produto { // herança
    public ProdutoImportado(String nome, double preco, int estoque) {
        super(nome, preco, estoque); // Envia os dados para o construtor do Pai
    }

    @Override // Isso avisa ao compilador que você está mudando uma regra do pai
    public Double getPreco() {
        // super.getPreco() chama o preço original do pai
        // depois multiplicamos por 1.15 (15% de taxa)
        return super.getPreco() * 1.15;
    }
}