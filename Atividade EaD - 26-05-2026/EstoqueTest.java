import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class EstoqueTest {
    private Estoque estoque;

    @BeforeEach
    void setup() {
        estoque = new Estoque();
    }

    @Test
    @DisplayName("Adicionar novo produto")
    void testAdicionarProduto() {
        estoque.adicionarProduto("Teclado", 10);
        assertEquals(10, estoque.getQuantidade("Teclado"));
    }

    @Test
    @DisplayName("Remover produto existente")
    void testRemoverProduto() {
        estoque.adicionarProduto("Mouse", 5);
        estoque.removerProduto("Mouse", 2);
        assertEquals(3, estoque.getQuantidade("Mouse"));
    }

    @Test
    @DisplayName("Lançar exceção ao remover produto não existente")
    void testRemoverProdutoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> estoque.removerProduto("Monitor", 1));
    }

    @Test
    @DisplayName("Lançar exceção ao remover quantidade superior ao estoque")
    void testRemoverAcimaDoEstoque() {
        estoque.adicionarProduto("Cabo HDMI", 2);
        assertThrows(IllegalStateException.class, () -> estoque.removerProduto("Cabo HDMI", 5));
    }

    @Test
    @DisplayName("Verificar se produto existe no estoque")
    void testTemProduto() {
        estoque.adicionarProduto("Fone", 1);
        assertTrue(estoque.temProduto("Fone"));
        assertFalse(estoque.temProduto("Webcam"));
    }
}
