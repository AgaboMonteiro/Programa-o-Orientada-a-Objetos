public class Passaro extends Animal implements Voador{

    public Passaro (String nome){
        super(nome);
    }

    @Override
    public void emitirSom(){
        System.out.println("UIIIIUU UIIIUU UIIIIU");
    }

    @Override
    public void voar(){
        System.out.println("viuuuuummmm");
    }
}
