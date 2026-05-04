public class Main {
    public static void main(String[] args) {

        UsuarioService service = new UsuarioService();
        UsuarioController controller = new UsuarioController(service);
        UsuarioView view = new UsuarioView(controller);

        view.menu();
    }
}