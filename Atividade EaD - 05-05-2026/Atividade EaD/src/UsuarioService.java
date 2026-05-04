import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public String cadastrar(String nome, String email, String telefone) {

        // validação de email
        if (!email.contains("@") || !email.contains(".")) {
            return "Erro: e-mail inválido";
        }

        Usuario usuario = new Usuario(nome, email, telefone);
        usuarios.add(usuario);

        return "Usuário cadastrado com sucesso";
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
}