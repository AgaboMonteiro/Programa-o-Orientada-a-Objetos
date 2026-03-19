/* 10 - Crie a classe Animal com nome e o método emitirSom() e crie as
classes Cachorro e Gato herdando da classe Animal, onde cada
subclasse implementa o método emitirSom() do “seu jeito”. */

public class Cachorro extends Animal {
    @Override
    public void emitirSom(){
        System.out.println("AU, AU AU");
    }
}
