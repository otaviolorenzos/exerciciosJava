public abstract class Produto {
    protected String nome;
    protected Double preco;
    protected int estoqueDisponivel;

    public String getNome () {
        return this.nome;
    }

    public Double getPreco () {
        return this.preco;
    }

    public int getEstoqueDisponivel() {
        return this.estoqueDisponivel;
    }

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoqueDisponivel = estoque;
    }


}
