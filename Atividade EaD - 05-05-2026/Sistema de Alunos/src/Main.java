
public class Main {
    public static void main(String[] args) {

        AlunoRepository repo = new AlunoRepository();
        AlunoService service = new AlunoService(repo);
        AlunoController controller = new AlunoController(service);
        AlunoView view = new AlunoView(controller);

        System.out.println("Cadastrando: Ana, 101, 8.5 -> " + controller.cadastrar("Ana", "101", 8.5));
        System.out.println("Cadastrando: Bruno, 102, 11.0 -> " + controller.cadastrar("Bruno", "102", 11.0));
        System.out.println("Cadastrando: Carlos, 101, 7.0 -> " + controller.cadastrar("Carlos", "101", 7.0));
        System.out.println("Cadastrando: Daniela, 103, 9.0 -> " + controller.cadastrar("Daniela", "103", 9.0));

        view.listar();
        view.mostrarMedia();
    }
}