/*5 - Crie uma classe Pessoa com atributos privados (nome e idade) e crie métodos
para setar os atributos e obtê-los (getters e setters).

6 - Modifique o Exercício 5 para que seja criado um construtor que permita criar a
pessoa já com nome e idade.

7 - Modifique o Exercício 6 para não permitir idade negativa ou idade maior que
100 (trate isso no setIdade()).
*/

public class Pessoa{
    private String nome;
    private int idade;

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        if (idade <0 || idade > 100){
            System.out.println("Idade não permitida. A idade não deve ser negativa e deve ser entre 0 e 100.");
        }
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }
    
    public int getIdade(){
        return idade;
    }

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

}