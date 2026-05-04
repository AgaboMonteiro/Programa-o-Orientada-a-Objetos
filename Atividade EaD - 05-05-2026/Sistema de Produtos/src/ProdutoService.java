import java.util.List;

public class ProdutoService {

    private ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public void cadastrar(String nome, double preco, int quantidade) {
        repo.salvar(new Produto(nome, preco, quantidade));
    }

    public List<Produto> listar() {
        return repo.listarTodos();
    }

    public Produto buscar(String nome) {
        return repo.buscarPorNome(nome);
    }
}