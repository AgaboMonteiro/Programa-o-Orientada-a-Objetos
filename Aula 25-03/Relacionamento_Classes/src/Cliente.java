public class Cliente {
    protected String nome;
    protected int cpf;

    public void nome (String nome){
        this.nome = nome;
    }

    public void cpf (int cpf){
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf(){
        return cpf;
    }


}

