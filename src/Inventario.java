import java.util.ArrayList;

public class Inventario {
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>(); // Uma única lista que guarda objetos do tipo Produto
    private Double valorNoCarrinho = 0.0;

    public Inventario() {
        // Criamos o objeto e já guardamos na lista
        this.listaDeProdutos.add(new ProdutoComum("Mouse", 29.9, 5));
        this.listaDeProdutos.add(new ProdutoComum("Teclado", 79.5, 7));
        this.listaDeProdutos.add(new ProdutoComum("Monitor", 899.2, 9));
        this.listaDeProdutos.add(new ProdutoComum("Webcam", 137.45, 4));
        this.listaDeProdutos.add(new ProdutoComum("Headset", 119.9, 8));
        this.listaDeProdutos.add(new ProdutoImportado("Mousepad RGB", 119.9, 15));
        this.listaDeProdutos.add(new ProdutoPromocao("Teclado RGB", 9.9, 5));
        this.listaDeProdutos.add(new ProdutoPromocao("Teclado RGB Black and White", 75, 32));

    }
    //getters
    public double getValorNoCarrinho() {
        return this.valorNoCarrinho;
    }

    public String getNomeDoProdutoNoIndice(int indice) {
        return listaDeProdutos.get(indice - 1).getNome();
    }

    public int getEstoqueDoProdutoNoIndice(int indice) {
        return listaDeProdutos.get(indice - 1).getEstoqueDisponivel();
    }

    public void ExibirInventario() {
        System.out.println("------------- PRODUTOS -------------");

        for (int i = 0; i < listaDeProdutos.size(); i++) {
            Produto p = listaDeProdutos.get(i); // pegamos o objeto Produto em i dentro da lista de objetos Produto
            // p serve para não "buscar" varias vezes para todos os atributos. Buscamos apenas uma vez (váriavel de referência)
            System.out.println(String.format("[%d] %s: R$%.2f (Estoque: %d)",
                    i + 1,
                    p.getNome(),
                    p.getPreco(),
                    p.getEstoqueDisponivel()));
        }
        System.out.println("------------- PRODUTOS -------------");
    }

    public boolean AnalisarSeExisteP(int itemAComprar){  //Analisa de está fora do intervalo de produtos
        if (itemAComprar <= 0 || itemAComprar > listaDeProdutos.size()) {
            System.out.println("Número Inválido, tente novamente.");
            return false;
        } return true;
    }

    public boolean VerificarEstoque(int unidades, int itemAComprar){
        Produto p = listaDeProdutos.get(itemAComprar-1);
        if (unidades > p.getEstoqueDisponivel()){
            System.out.println("Estoque indisponível para quantidade desejada, tente novamente.");
            return true;
        } else if (unidades <= 0){
            System.out.println("Número inválido, tente novamente.");
            return true;
        }
        return false;
    }

    public Double AddAoCarrinho(int itemAComprar, int unidades){
        Produto p = listaDeProdutos.get(itemAComprar-1);
        this.valorNoCarrinho = this.valorNoCarrinho + (p.getPreco()*unidades);
        int estoqueAtual = p.getEstoqueDisponivel() - unidades;
        p.setEstoqueDisponivel(estoqueAtual);
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


    public void cadastrarNovoProduto(String nome, double preco, int estoque, int tipo) {
            Produto novo; // Criamos uma referência do tipo pai

            if (tipo == 2) {
                novo = new ProdutoImportado(nome, preco, estoque);
            } else if (tipo == 3) {
                novo = new ProdutoPromocao(nome, preco, estoque);
            } else {
                // Agora você precisará da classe ProdutoComum para os itens normais
                novo = new ProdutoComum(nome, preco, estoque);
            }

            this.listaDeProdutos.add(novo);
            System.out.println("✅ " + nome + " cadastrado como " + novo.getClass().getSimpleName());
    }

    public void aplicarDescontoEspecial(int indice, double porcentagem) {
        Produto p = listaDeProdutos.get(indice - 1);


        if (p instanceof Promocional) {
            ((Promocional) p).aplicarCupom(porcentagem);
            System.out.println("Cupom aplicado com sucesso!");
        } else {
            System.out.println("Este produto não aceita cupons de desconto.");
        }
    }


}
