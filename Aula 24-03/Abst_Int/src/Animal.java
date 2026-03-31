public abstract class Animal {
    protected String nome;

    public void emitirSom(){
        System.out.println("O animal emite um som.");
    }

    public Animal (String nome){
        this.nome = nome;
    }


    //abstract void emitirSom();
}
