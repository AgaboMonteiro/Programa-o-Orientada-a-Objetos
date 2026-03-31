public class Peixe extends Animal implements Nadador {

    public Peixe(String nome){
        super(nome);
    }

    @Override
    public void  emitirSom(){
        System.out.println("Glub Glub");
    }

    @Override
    public void nadar(){
        System.out.println("shuu shuu shuuu");
    }
}
