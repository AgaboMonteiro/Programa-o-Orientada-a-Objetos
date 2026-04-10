import java.util.HashMap;
import java.util.Map;

class ReservaAerea {
    private String numeroVoo;
    private String cpfPassageiro;
    private int idadePassageiro;
    private double valorPassagem;
    private int assentosDisponiveis;
    private boolean vooInternacional;
    private boolean passageiroPossuiVisto;
    private double saldoCliente;

    private static Map<String, Integer> reservasPorCpf = new HashMap<>();

    public ReservaAerea(String numeroVoo, String cpfPassageiro, int idadePassageiro, double valorPassagem,
                        int assentosDisponiveis, boolean vooInternacional, boolean passageiroPossuiVisto,
                        double saldoCliente) {
        this.numeroVoo = numeroVoo;
        this.cpfPassageiro = cpfPassageiro;
        this.idadePassageiro = idadePassageiro;
        this.valorPassagem = valorPassagem;
        this.assentosDisponiveis = assentosDisponiveis;
        this.vooInternacional = vooInternacional;
        this.passageiroPossuiVisto = passageiroPossuiVisto;
        this.saldoCliente = saldoCliente;
    }

    public void reservar() throws IdadeMinimaException, IdadeMaximaException, SemAssentoException,
                                  SaldoInsuficienteException, SemVistoException, CpfInvalidoException,
                                  ValorInvalidoException, LimiteReservasException {
        if (idadePassageiro < 18) throw new IdadeMinimaException("ERRO_IDADE_MINIMA");
        if (idadePassageiro > 100) throw new IdadeMaximaException("ERRO_IDADE_MAXIMA");
        if (assentosDisponiveis == 0) throw new SemAssentoException("ERRO_SEM_ASSENTO");
        if (valorPassagem > saldoCliente) throw new SaldoInsuficienteException("ERRO_SALDO_INSUFICIENTE");
        if (vooInternacional && !passageiroPossuiVisto) throw new SemVistoException("ERRO_SEM_VISTO");
        if (cpfPassageiro == null || !cpfPassageiro.matches("\\d{11}")) throw new CpfInvalidoException("ERRO_CPF_INVALIDO");
        if (valorPassagem <= 0) throw new ValorInvalidoException("ERRO_VALOR_INVALIDO");
        
        int reservasAtuais = reservasPorCpf.getOrDefault(cpfPassageiro, 0);
        if (reservasAtuais >= 3) throw new LimiteReservasException("ERRO_LIMITE_RESERVAS");

        reservasPorCpf.put(cpfPassageiro, reservasAtuais + 1);
        this.assentosDisponiveis--;
        System.out.println("SUCESSO: Reserva confirmada!");
    }

    public static void limparReservas() {
        reservasPorCpf.clear();
    }
}