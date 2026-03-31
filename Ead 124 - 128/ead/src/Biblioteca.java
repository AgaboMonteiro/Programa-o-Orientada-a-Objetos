import java.util.ArrayList;
import java.time.LocalDate;

public class Biblioteca {
    
    private String nome;
    private ArrayList<Livro> livros;
    private ArrayList<Emprestimo> emprestimos;
    
    public Biblioteca(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>(); 
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLivros(ArrayList<Livro> livros){ 
        this.livros = livros;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos){  // CORRIGIDO: setEmprestimos
        this.emprestimos = emprestimos;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public ArrayList<Emprestimo> getEmprestimos(){
        return emprestimos;
    }
    
    // Métodos úteis para a biblioteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }
    
    public void registrarEmprestimo(Livro livro, Leitor leitor) {
        Emprestimo emprestimo = new Emprestimo(livro, leitor);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo registrado para: " + leitor.getNome());
    }
    
    public void listarLivros() {
        System.out.println("\n=== LIVROS DA BIBLIOTECA " + nome + " ===");
        for (Livro livro : livros) {
            System.out.println(livro);
            System.out.println("---");
        }
    }
    
    public void listarEmprestimos() {
        System.out.println("\n=== EMPRÉSTIMOS ===");
        for (Emprestimo emp : emprestimos) {
            System.out.println(emp);
            System.out.println("---");
        }
    }
}