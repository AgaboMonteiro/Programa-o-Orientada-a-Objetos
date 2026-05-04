import java.util.List;

public class ProdutoView {

    private ProdutoController controller;

    public ProdutoView(ProdutoController controller) {
        this.controller = controller;
    }

    public void listar() {
        List<Produto> lista = controller.listar();

        System.out.println("Lista de produtos:");
        for (Produto p : lista) {
            System.out.println(p.getNome() + " - R$" + p.getPreco() + " - " + p.getQuantidade() + " unidades");
        }
    }

    public void buscar(String nome) {
        System.out.println("\nBuscando '" + nome + "':");

        Produto p = controller.buscar(nome);

        if (p != null) {
            System.out.println(p.getNome() + " - R$" + p.getPreco() + " - " + p.getQuantidade() + " unidades");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}