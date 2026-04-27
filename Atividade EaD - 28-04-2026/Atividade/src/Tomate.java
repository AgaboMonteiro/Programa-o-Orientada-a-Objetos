public class Tomate extends SanduicheDecorator {

    public Tomate(Sanduiche s) {
        super(s);
    }

    @Override
    public String getDescricao() {
        return sanduiche.getDescricao() + ", Tomate";
    }

    @Override
    public double getPreco() {
        return sanduiche.getPreco() + 1.5;
    }
}