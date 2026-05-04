import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public void salvar(Produto p) {
        produtos.add(p);
    }

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto buscarPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}