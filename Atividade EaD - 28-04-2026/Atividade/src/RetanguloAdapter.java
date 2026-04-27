public class RetanguloAdapter implements AreaCalculavel {

    private CalculadoraDeAreaRetangulo calculadora;
    private double largura;
    private double altura;

    public RetanguloAdapter(double largura, double altura) {
        this.calculadora = new CalculadoraDeAreaRetangulo();
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return calculadora.calcular(largura, altura);
    }
}