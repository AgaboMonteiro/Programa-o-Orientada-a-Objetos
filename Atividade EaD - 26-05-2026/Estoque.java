import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtos = new HashMap<>();

    public void adicionarProduto(String nome, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        produtos.put(nome, produtos.getOrDefault(nome, 0) + quantidade);
    }

    public void removerProduto(String nome, int quantidade) {
        if (!produtos.containsKey(nome)) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        int atual = produtos.get(nome);
        if (quantidade > atual) {
            throw new IllegalStateException("Quantidade insuficiente no estoque");
        }
        produtos.put(nome, atual - quantidade);
    }

    public int getQuantidade(String nome) {
        return produtos.getOrDefault(nome, 0);
    }

    public boolean temProduto(String nome) {
        return produtos.containsKey(nome) && produtos.get(nome) > 0;
    }
}
