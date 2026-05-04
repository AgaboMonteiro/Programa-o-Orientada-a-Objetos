import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno a) {
        alunos.add(a);
    }

    public boolean existePorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }
}