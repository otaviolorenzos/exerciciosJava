public class ProdutoPromocao extends Produto {
    public ProdutoPromocao(String nome, double preco, int estoque){
        super(nome, preco, estoque);
    }

    @Override
    public Double getPreco() {
        return super.getPreco()*0.8;
    }
}
