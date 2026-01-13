public class ProdutoPromocao extends Produto implements Promocional {
    public ProdutoPromocao(String nome, double preco, int estoque){
        super(nome, preco, estoque);
    }
    @Override
    public Double getPreco() {
        return super.getPreco()*0.8;
    }

    @Override
    public void aplicarCupom(double porcentagem) {
        this.preco = this.preco - (this.preco * (porcentagem /100));
    }

}
