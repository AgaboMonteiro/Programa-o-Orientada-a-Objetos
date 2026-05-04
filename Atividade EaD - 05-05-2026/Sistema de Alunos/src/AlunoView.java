import java.util.List;

public class AlunoView {

    private AlunoController controller;

    public AlunoView(AlunoController controller) {
        this.controller = controller;
    }

    public void listar() {
        System.out.println("Lista de alunos:");
        for (Aluno a : controller.listar()) {
            System.out.println(a.getNome() + " (" + a.getMatricula() + ") - " + a.getNota());
        }
    }

    public void mostrarMedia() {
        System.out.println("Média da turma: " + controller.media());
    }
}