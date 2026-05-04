import java.util.List;

public class AlunoService {

    private AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public String cadastrar(String nome, String matricula, double nota) {

        if (nota < 0 || nota > 10) {
            return "Erro: nota inválida";
        }

        if (repo.existePorMatricula(matricula)) {
            return "Erro: matrícula já cadastrada";
        }

        repo.salvar(new Aluno(nome, matricula, nota));
        return "sucesso";
    }

    public List<Aluno> listar() {
        return repo.listarTodos();
    }

    public double calcularMedia() {
        List<Aluno> lista = repo.listarTodos();

        double soma = 0;
        for (Aluno a : lista) {
            soma += a.getNota();
        }

        return lista.isEmpty() ? 0 : soma / lista.size();
    }
}