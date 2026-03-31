public class Livro {
    private String titulo;
    private Autor autor;
    private int ano;
    private boolean disponivel;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    
    public String getTitulo() {
        return this.titulo;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public int getAno() {
        return this.ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void emprestar() {
        if(disponivel) {
            this.disponivel = false;
            System.out.println("Livro: " + titulo + " foi emprestado");
        } else {
            System.out.println("Livro " + titulo + " não está disponível");
        }
    }

    public void devolver() {
        this.disponivel = true;
        System.out.println("Livro " + titulo + " devolvido");
    }

    public Livro(String titulo, Autor autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
               "\nAno: " + ano +
               "\nAutor: " + autor.getNome() + 
               "\nStatus: " + (disponivel ? "Disponível" : "Emprestado");
    }
}