public class Aviao implements Voador {

    protected String marca;
    protected String cor;
    protected int tamanho;

    public void marca (String marca){
        this.marca = marca;
    }

    public void cor (String cor){
        this.cor = cor;
    }

    public void tamanho (int tamanho){
        this.tamanho = tamanho;
    }

    public Aviao (String marca, String cor, int tamanho){
        this.marca = marca;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    @Override
    public void voar(){
        System.out.println("O AVIÃO VOA");
    }


    
}
