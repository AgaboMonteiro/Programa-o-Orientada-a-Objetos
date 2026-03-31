public class Pato extends Animal implements Nadador, Voador {

    public Pato (String nome){
        super(nome);
    }

    @Override
    public void emitirSom(){
        System.out.println("Quack Quack");
    }

    @Override
    public void nadar(){
        System.out.println("shuu shuu shuuu");
    }

    @Override
    public void voar(){
        System.out.println("viiiiiiummmmm");
    }

}
