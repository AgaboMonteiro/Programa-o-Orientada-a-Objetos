import java.util.ArrayList;
import java.util.List;

public class EstacaoClimatica implements Sujeito {

    private List<Display> displays = new ArrayList<>();
    private float temperatura, umidade, pressao;

    public void setMedidas(float t, float u, float p) {
        this.temperatura = t;
        this.umidade = u;
        this.pressao = p;
        notificar();
    }

    @Override
    public void adicionar(Display d) {
        displays.add(d);
    }

    @Override
    public void remover(Display d) {
        displays.remove(d);
    }

    @Override
    public void notificar() {
        for (Display d : displays) {
            d.atualizar(temperatura, umidade, pressao);
        }
    }
}