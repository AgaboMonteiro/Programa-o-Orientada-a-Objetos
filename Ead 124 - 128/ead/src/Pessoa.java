public abstract class Pessoa{

    private String nome;
    private String email;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public Pessoa(){

    }

    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email=email;
    }

    @Override
    public String toString(){
        return "Nome: "+nome+"\nEmail: "+email;
    }
}