public class Main {
    public static void main(String[] args) {

        ProdutoRepository repo = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repo);
        ProdutoController controller = new ProdutoController(service);
        ProdutoView view = new ProdutoView(controller);

        System.out.println("Cadastrando produto: Notebook - R$2500.00 - 10 unidades");
        controller.cadastrar("Notebook", 2500.00, 10);

        System.out.println("Cadastrando produto: Mouse - R$80.00 - 50 unidades");
        controller.cadastrar("Mouse", 80.00, 50);

        view.listar();

        view.buscar("Mouse");
        view.buscar("Teclado");
    }
}