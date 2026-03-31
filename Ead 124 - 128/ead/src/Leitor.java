public class Leitor extends Pessoa{

    private String matricula;


    public void setMatricula(String matricula){
        this.matricula = matricula;
    }    

    public String getMatricula(){
        return this.matricula;
    }

    public Leitor(String matricula, String nome, String email){
        super(nome,email);
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return "Leitor: "+ getNome() + "\nMatricula: "+ matricula;
    }
}