public class Bacon extends SanduicheDecorator {

    public Bacon(Sanduiche s) {
        super(s);
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao() + ", Bacon";
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco() + 3.0;
    }
}