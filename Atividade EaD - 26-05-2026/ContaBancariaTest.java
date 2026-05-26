import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ContaBancariaTest {

    @Test
    @DisplayName("Criar conta com saldo positivo")
    void testCriarContaSaldoPositivo() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Lançar exceção ao criar conta com saldo negativo")
    void testCriarContaSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(-50.0));
    }

    @Test
    @DisplayName("Depositar valor positivo")
    void testDepositarValorPositivo() {
        ContaBancaria conta = new ContaBancaria(100.0);
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Lançar exceção ao depositar valor negativo")
    void testDepositarValorNegativo() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10.0));
    }

    @Test
    @DisplayName("Sacar valor válido")
    void testSacarValorValido() {
        ContaBancaria conta = new ContaBancaria(100.0);
        conta.sacar(40.0);
        assertEquals(60.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Lançar exceção ao sacar com saldo insuficiente")
    void testSacarSaldoInsuficiente() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertThrows(IllegalStateException.class, () -> conta.sacar(150.0));
    }

    @Test
    @DisplayName("Lançar exceção ao sacar valor negativo")
    void testSacarValorNegativo() {
        ContaBancaria conta = new ContaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-20.0));
    }

    // Testes extras
    @Test
    @DisplayName("Sacar valor igual ao saldo (Extra 1)")
    void testSacarTudo() {
        // Explicação: Verifica se é possível zerar o saldo exatamente
        ContaBancaria conta = new ContaBancaria(100.0);
        conta.sacar(100.0);
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Depósito de valor zero (Extra 2)")
    void testDepositarZero() {
        // Explicação: Verifica se o sistema impede depósito de valor nulo
        ContaBancaria conta = new ContaBancaria(100.0);
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));
    }
}
