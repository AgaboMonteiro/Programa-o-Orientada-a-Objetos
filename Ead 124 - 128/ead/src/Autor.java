public class Autor extends Pessoa {
    
    private String biografia;



    public Autor(String biografia, String nome, String email){
        super(nome,email);
        this.biografia = biografia;
    }

    public void setBiografia(String biografia){
        this.biografia = biografia;
    }

    public String getBiografia(){
        return this.biografia;
    }

    @Override
    public String toString(){
        return "Autor: "+getNome()+"\nBiografia: "+biografia;
    }
    
}