import java.util.List;

public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    public String cadastrar(String nome, String matricula, double nota) {
        return service.cadastrar(nome, matricula, nota);
    }

    public List<Aluno> listar() {
        return service.listar();
    }

    public double media() {
        return service.calcularMedia();
    }
}