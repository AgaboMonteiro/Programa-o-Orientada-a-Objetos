/*4 - Crie uma classe Carro com marca e ano e crie um construtor vazio e um
construtor com parâmetros.*/

public class Carro {
    private String marca;
    private int ano;

    public void marca(String marca){
        this.marca = marca;
    }

    public void ano (int ano){
        this.ano = ano;
    }

    public String getMarca(){
        return marca;
    }

    public int getAno(){
        return ano;
    }

    public Carro(){//construtor vazio
    }

    public Carro (String marca, int ano){ //construtor com parâmetros
        this.marca = marca;
        this.ano = ano;
    }   
    
}
