public class Queijo extends SanduicheDecorator {

    public Queijo(Sanduiche s) {
        super(s);
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao() + ", Queijo";
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco() + 2.0;
    }
}
