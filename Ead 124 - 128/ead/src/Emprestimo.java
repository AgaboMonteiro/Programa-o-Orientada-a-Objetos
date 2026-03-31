import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Leitor leitor;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private boolean ativo;

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public Leitor getLeitor() {
        return this.leitor;
    }

    // CORRIGIDOS: Getters sem recursão
    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return this.dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return this.dataDevolucaoReal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Emprestimo(Livro livro, Leitor leitor) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(7);
        this.ativo = true;
        this.livro.setDisponivel(false);
    }

    public void devolver() {
        if (ativo) {
            this.dataDevolucaoReal = LocalDate.now();
            this.ativo = false;
            this.livro.devolver();
            System.out.println("Empréstimo finalizado!");
        }
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() +
                "\nLeitor: " + leitor.getNome() +
                "\nData Empréstimo: " + dataEmprestimo +
                "\nDevolução Prevista: " + dataDevolucaoPrevista +
                "\nStatus: " + (ativo ? "ATIVO" : "FINALIZADO");
    }
}