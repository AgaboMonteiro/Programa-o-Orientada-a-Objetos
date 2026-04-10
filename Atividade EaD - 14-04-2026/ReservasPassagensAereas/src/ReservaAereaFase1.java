import java.util.HashMap;
import java.util.Map;

public class ReservaAereaFase1 {

private String numeroVoo;
private String cpfPassageiro;
private int idadePassageiro;
private double valorPassagem;
private int assentosDisponiveis;
private boolean vooInternacional;
private boolean passageiroPossuiVisto;
private double saldoCliente;

    // Mapa estático para simular o controle de reservas por CPF
    private static Map<String, Integer> reservasPorCpf = new HashMap<>();

public ReservaAereaFase1(String numeroVoo, String cpfPassageiro, int idadePassageiro, double valorPassagem, 
    int assentosDisponiveis, boolean vooInternacional, boolean passageiroPossuiVisto, double saldoCliente) {
    this.numeroVoo = numeroVoo;
    this.cpfPassageiro = cpfPassageiro;
    this.idadePassageiro = idadePassageiro;
    this.valorPassagem = valorPassagem;
    this.assentosDisponiveis = assentosDisponiveis;
    this.vooInternacional = vooInternacional;
    this.passageiroPossuiVisto = passageiroPossuiVisto;
    this.saldoCliente = saldoCliente;
}


public String reservar() {
    if (idadePassageiro < 18) {//Idade mínima (Idade < 18 anos) [“ERRO_IDADE_MINIMA”]
        return "ERRO_IDADE_MINIMA.";
    } else if (idadePassageiro > 100) {//Idade máxima (Idade > 100 anos) [“ERRO_IDADE_MAXIMA”]
        return "ERRO_IDADE_MAXIMA.";
    } else if (assentosDisponiveis == 0) { //Assento disponível (A_disp == 0) [“ERRO_SEM_ASSENTO”]
        return "ERRO_SEM_ASSENTO.";
    } else if (valorPassagem>saldoCliente) { //Saldo suficiente (ValorPassagem > SaldoCliente)[“ERRO_SALDO_INSUFICIENTE”]
        return "ERRO_SALDO_INSUFICIENTE.";
    } else if (vooInternacional && !passageiroPossuiVisto) { //Visto internacional (Se vooInternacional = true E passageiroPossuiVisto = false) [“ERRO_SEM_VISTO”]
        return "ERRO_SEM_VISTO.";
    } else if (cpfPassageiro.length() != 11 || !cpfPassageiro.matches("\\d+")) { //CPF válido (CPF deve ter 11 dígitos - apenas números) [“ERRO_CPF_INVALIDO”]
        return "ERRO_CPF_INVALIDO.";
    } else if (valorPassagem <= 0) { //Valor da passagem (ValorPassagem <= 0) [“ERRO_VALOR_INVALIDO”]
        return "ERRO_VALOR_INVALIDO.";
    }   //Limite por CPF (Mesmo CPF não pode ter mais de 3 reservas ativas) [“ERRO_LIMITE_RESERVAS”]
    int reservasAtuais = reservasPorCpf.getOrDefault(cpfPassageiro, 0);
        if (reservasAtuais >= 3) {
            return "ERRO_LIMITE_RESERVAS";
        }
        
        // Se tudo OK
        reservasPorCpf.put(cpfPassageiro, reservasAtuais + 1);
        this.assentosDisponiveis--;
        return "SUCESSO";
}

    public static void limparReservas() {
        reservasPorCpf.clear();
    }

}