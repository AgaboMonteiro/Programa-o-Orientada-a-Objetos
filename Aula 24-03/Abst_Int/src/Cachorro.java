public class Cachorro extends Animal {

    public Cachorro(String nome){
        super(nome);//super se refere ao metodo da classe pai
    }

    @Override
    public void emitirSom(){
        System.out.println("Au au au");
    }


}
