import java.util.List;
import java.util.Scanner;

public class UsuarioView {

    private UsuarioController controller;
    private Scanner sc = new Scanner(System.in);

    public UsuarioView(UsuarioController controller) {
        this.controller = controller;
    }

    public void menu() {

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por email");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
            }

        } while (opcao != 0);
    }

    private void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Telefone (opcional): ");
        String telefone = sc.nextLine();

        if (telefone.isEmpty()) {
            telefone = null;
        }

        String resposta = controller.cadastrarUsuario(nome, email, telefone);
        System.out.println(resposta);
    }

    private void listar() {
        List<Usuario> lista = controller.listarUsuarios();

        for (Usuario u : lista) {
            System.out.println(
                    u.getNome() + " - " +
                            u.getEmail() + " - " +
                            (u.getTelefone() != null ? u.getTelefone() : "Sem telefone")
            );
        }
    }

    private void buscar() {
        System.out.print("Digite o email: ");
        String email = sc.nextLine();

        Usuario u = controller.buscarUsuario(email);

        if (u != null) {
            System.out.println("Encontrado:");
            System.out.println(
                    u.getNome() + " - " +
                            u.getEmail() + " - " +
                            (u.getTelefone() != null ? u.getTelefone() : "Sem telefone")
            );
        } else {
            System.out.println("Usuário não encontrado");
        }
    }
}