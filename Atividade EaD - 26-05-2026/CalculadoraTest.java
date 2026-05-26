import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTest {
    Calculadora calc = new Calculadora();

    @Test
    @DisplayName("Soma de dois números positivos")
    void testSomaPositivos() {
        assertEquals(8, calc.somar(5, 3));
    }

    @Test
    @DisplayName("Subtração resultando em número negativo")
    void testSubtracaoNegativos() {
        assertEquals(-3, calc.subtrair(2, 5));
    }

    @Test
    @DisplayName("Multiplicação por zero")
    void testMultiplicacaoZero() {
        assertEquals(0, calc.multiplicar(0, 10));
    }

    @Test
    @DisplayName("Divisão exata")
    void testDivisaoExata() {
        assertEquals(5.0, calc.dividir(10, 2));
    }

    @Test
    @DisplayName("Lançar exceção ao dividir por zero")
    void testDivisaoPorZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.dividir(10, 0));
    }

    // --- Exercício 7: Operações Completas com assertAll ---
    @Test
    @DisplayName("Validar todas as operações básicas em um único fluxo")
    void testeOperacoesCompletas() {
        assertAll("Operações básicas",
            () -> assertEquals(10, calc.somar(7, 3), "Falha na soma"),
            () -> assertEquals(5, calc.subtrair(10, 5), "Falha na subtração"),
            () -> assertEquals(20, calc.multiplicar(4, 5), "Falha na multiplicação"),
            () -> assertEquals(2.0, calc.dividir(8, 4), "Falha na divisão")
        );
    }

    // --- Exercício 8: Teste Parametrizado para Multiplicar ---
    @ParameterizedTest
    @DisplayName("7 cenários de multiplicação")
    @CsvSource({
        "2, 3, 6",
        "5, 5, 25",
        "10, 0, 0",
        "-2, 4, -8",
        "-3, -3, 9",
        "0, 100, 0",
        "1, 50, 50"
    })
    void testMultiplicarParametrizado(int a, int b, int esperado) {
        assertEquals(esperado, calc.multiplicar(a, b));
    }

    // Testes extras originais
    @Test
    @DisplayName("Multiplicação de dois números negativos (Extra 1)")
    void testMultiplicacaoNegativos() {
        assertEquals(15, calc.multiplicar(-3, -5));
    }

    @Test
    @DisplayName("Soma com zero (Extra 2)")
    void testSomaComZero() {
        assertEquals(10, calc.somar(10, 0));
    }
}
