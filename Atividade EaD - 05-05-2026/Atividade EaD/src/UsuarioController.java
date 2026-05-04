import java.util.List;

public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public String cadastrarUsuario(String nome, String email, String telefone) {
        return service.cadastrar(nome, email, telefone);
    }

    public List<Usuario> listarUsuarios() {
        return service.listar();
    }

    public Usuario buscarUsuario(String email) {
        return service.buscarPorEmail(email);
    }
}