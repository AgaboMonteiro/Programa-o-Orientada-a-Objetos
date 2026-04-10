public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Iniciando Testes Fase 2 ---");

        testarReserva("Cenário 1 (Válida)", "V1", "11111111111", 25, 500.0, 10, false, false, 1000.0);
        testarReserva("Cenário 2 (Saldo Insuficiente)", "V2", "22222222222", 30, 500.0, 10, false, false, 100.0);
        testarReserva("Cenário 3 (Idade < 18)", "V3", "33333333333", 15, 500.0, 10, false, false, 1000.0);
        testarReserva("Cenário 4 (Internacional sem visto)", "V4", "44444444444", 40, 500.0, 10, true, false, 1000.0);
        testarReserva("Cenário 5 (Sem assento)", "V5", "55555555555", 35, 500.0, 0, false, false, 1000.0);

        System.out.println("\nCenário 6 (Limite por CPF):");
        ReservaAerea.limparReservas();
        String cpf = "66666666666";
        for (int i = 1; i <= 4; i++) {
            System.out.print("  Reserva " + i + ": ");
            testarReserva(null, "V6", cpf, 30, 100.0, 10, false, false, 1000.0);
        }
    }

    private static void testarReserva(String titulo, String voo, String cpf, int idade, double valor, int assentos, boolean internacional, boolean visto, double saldo) {
        if (titulo != null) System.out.print(titulo + ": ");
        try {
            ReservaAerea r = new ReservaAerea(voo, cpf, idade, valor, assentos, internacional, visto, saldo);
            r.reservar();
        } catch (Exception e) {
            System.out.println("Capturada Exceção: " + e.getMessage());
        }
    }
}
