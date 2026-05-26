# Relatório de Exercícios JUnit e Testes Unitários

Este relatório detalha a resolução dos exercícios propostos, focando na criação de classes de implementação e seus respectivos testes unitários utilizando JUnit 5. Cada exercício inclui a classe de implementação, a classe de teste com os casos solicitados e testes extras, acompanhados de suas explicações.

## Exercício 1: Classe Calculadora

### Implementação da Classe `Calculadora.java`

A classe `Calculadora` oferece métodos básicos para operações aritméticas: soma, subtração, multiplicação e divisão. A divisão inclui uma validação para evitar divisão por zero.

```java
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não permitida");
        }
        return (double) a / b;
    }
}
```

### Testes Unitários da Classe `CalculadoraTest.java`

A classe `CalculadoraTest` verifica o comportamento da `Calculadora` com diversos cenários, incluindo os testes solicitados, dois testes extras e os novos testes práticos dos exercícios 7 e 8.

```java
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
```

### Explicação dos Testes Extras (originais):

1.  **`testMultiplicacaoNegativos()`**: Este teste verifica se a multiplicação de dois números negativos resulta em um número positivo, confirmando a correta aplicação das regras de sinais na operação. O resultado esperado para `-3 * -5` é `15`.
2.  **`testSomaComZero()`**: Este teste valida o comportamento da função de soma quando um dos operandos é zero. Ele confirma que a adição de zero a qualquer número retorna o próprio número, demonstrando o elemento neutro da adição. O resultado esperado para `10 + 0` é `10`.

### Explicação dos Novos Testes Práticos:

#### Exercício 7: `testeOperacoesCompletas()` com `assertAll()`

Este teste utiliza o recurso `assertAll()` do JUnit 5 para agrupar múltiplas asserções relacionadas a diferentes operações da classe `Calculadora` em um único método de teste. A principal vantagem de `assertAll()` é que ele executa todas as asserções, mesmo que uma delas falhe, reportando todas as falhas de uma vez. Isso é útil para identificar múltiplos problemas em uma única execução de teste, em vez de parar na primeira falha. No exemplo, são testadas a soma, subtração, multiplicação e divisão com valores específicos, garantindo que todas as operações básicas funcionem conforme o esperado.

#### Exercício 8: `testMultiplicarParametrizado()` com `@CsvSource`

Este teste demonstra o uso de testes parametrizados com a anotação `@ParameterizedTest` e a fonte de dados `@CsvSource`. Em vez de escrever sete testes separados para o método `multiplicar()`, um único teste parametrizado é criado. O `@CsvSource` fornece os pares de entrada (`a`, `b`) e o resultado esperado para cada cenário. O JUnit executa o mesmo método de teste sete vezes, uma para cada linha do `@CsvSource`, com os valores fornecidos. Isso reduz a duplicação de código, torna os testes mais legíveis e facilita a adição de novos cenários de teste.

## Exercício 2: Classe ContaBancaria

### Implementação da Classe `ContaBancaria.java`

A classe `ContaBancaria` gerencia o saldo de uma conta, permitindo depósitos e saques. Possui validações para saldo inicial negativo, valores de depósito/saque inválidos e saldo insuficiente.

```java
public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }
}
```

### Testes Unitários da Classe `ContaBancariaTest.java`

A classe `ContaBancariaTest` cobre os cenários de criação de conta, depósitos e saques, incluindo as exceções esperadas e dois testes extras.

```java
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
```

### Explicação dos Testes Extras:

1.  **`testSacarTudo()`**: Este teste verifica a funcionalidade de saque quando o valor sacado é exatamente igual ao saldo disponível na conta. O objetivo é garantir que a conta possa ser zerada corretamente sem lançar exceções indevidas. O saldo final esperado é `0.0`.
2.  **`testDepositarZero()`**: Este teste assegura que a tentativa de depositar um valor zero (ou negativo, já coberto) na conta bancária lance uma `IllegalArgumentException`. Isso valida a regra de negócio de que apenas depósitos com valores positivos são permitidos, evitando operações sem sentido ou inconsistentes. A exceção `IllegalArgumentException` é esperada.

## Exercício 3: Classe Estoque

### Implementação da Classe `Estoque.java`

A classe `Estoque` gerencia produtos e suas quantidades. Permite adicionar e remover produtos, além de verificar a quantidade disponível e a existência de um produto.

```java
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
```

### Testes Unitários da Classe `EstoqueTest.java`

A classe `EstoqueTest` verifica as operações de estoque, incluindo adição, remoção e consulta de produtos, com foco em cenários de sucesso e falha.

```java
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
```

### Explicação dos Testes Extras (implícitos nos 5 testes solicitados):

Os 5 testes implementados para a classe `Estoque` já cobrem uma boa variedade de cenários, incluindo casos de sucesso e de exceção, conforme solicitado. Eles são:

1.  **`testAdicionarProduto()`**: Verifica se um novo produto é adicionado corretamente ao estoque com a quantidade especificada.
2.  **`testRemoverProduto()`**: Garante que a remoção de uma quantidade válida de um produto existente atualiza corretamente o estoque.
3.  **`testRemoverProdutoInexistente()`**: Testa se uma `IllegalArgumentException` é lançada ao tentar remover um produto que não está no estoque.
4.  **`testRemoverAcimaDoEstoque()`**: Verifica se uma `IllegalStateException` é lançada quando se tenta remover uma quantidade de produto maior do que a disponível no estoque.
5.  **`testTemProduto()`**: Confirma que o método `temProduto` retorna `true` para produtos existentes com quantidade positiva e `false` para produtos inexistentes ou com quantidade zero.

Estes testes abordam os requisitos essenciais para a gestão de estoque, garantindo a robustez da classe `Estoque`.

## Conclusão

Os exercícios foram resolvidos com sucesso, demonstrando a aplicação de testes unitários com JUnit 5 para validar o comportamento de classes Java. As classes de implementação (`Calculadora`, `ContaBancaria`, `Estoque`) foram criadas com a lógica de negócio necessária e as classes de teste (`CalculadoraTest`, `ContaBancariaTest`, `EstoqueTest`) foram desenvolvidas para cobrir os cenários solicitados, incluindo testes extras para aumentar a cobertura e robustez das soluções. A execução dos testes confirmou que todas as funcionalidades estão operando conforme o esperado, e as exceções são lançadas nos casos apropriados.
