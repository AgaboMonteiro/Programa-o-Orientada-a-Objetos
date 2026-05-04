import java.util.List;

public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    public void cadastrar(String nome, double preco, int qtd) {
        service.cadastrar(nome, preco, qtd);
    }

    public List<Produto> listar() {
        return service.listar();
    }

    public Produto buscar(String nome) {
        return service.buscar(nome);
    }
}