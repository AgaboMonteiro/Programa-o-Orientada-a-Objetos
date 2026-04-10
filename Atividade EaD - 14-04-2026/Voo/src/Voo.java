// A classe Voo com atributos: numeroVoo, assentosDisponiveis, valorPassagem
public class Voo {
    private String numeroVoo;    
    private int assentosDisponiveis;
    private double valorPassagem;

    public Voo(String numeroVoo, int assentosDisponiveis, double valorPassagem) {
        this.numeroVoo = numeroVoo;
        this.assentosDisponiveis = assentosDisponiveis;
        this.valorPassagem = valorPassagem;
    }

    //O método reservarAssento(int quantidade, double valorPago) que:
    //Se quantidade <= 0: lança ValorInvalidoException
    //○ Se quantidade > assentosDisponiveis: lança VooLotadoException
    //○ Se valorPago < (quantidade * valorPassagem): lança ValorInvalidoException com mensagem adequada
    

        public void reservarAssento(int quantidade, double valorPago) throws ValorInvalidoException, VooLotadoException {
        if (quantidade <= 0) {
            throw new ValorInvalidoException("Quantidade deve ser maior que zero.");
        }
        if (quantidade > assentosDisponiveis) {
            throw new VooLotadoException("Não há assentos suficientes disponíveis.");
        }
        if (valorPago < (quantidade * valorPassagem)) {
            throw new ValorInvalidoException("Valor pago é insuficiente.");
        }
    }

    // O método cancelarVoo() que lança VooCanceladoException

    public void cancelarVoo() throws VooCanceladoException {
        throw new VooCanceladoException("O voo foi cancelado.");
    }

    
}//fim classe