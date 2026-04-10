public class App {
    public static void main(String[] args) throws Exception {
        Voo voo1 = new Voo("AB123", 100, 500.0);

        //Uma reserva bem-sucedida
        try {
            voo1.reservarAssento(2, 1000.0);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ValorInvalidoException | VooLotadoException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        //Uma reserva com valor insuficiente
        try {
            voo1.reservarAssento(2, 800.0);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ValorInvalidoException | VooLotadoException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        //Uma reserva com voo lotado
        try {
            voo1.reservarAssento(200, 10000.0);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ValorInvalidoException | VooLotadoException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }

        //O cancelamento do voo
        try {
            voo1.cancelarVoo();
        } catch (VooCanceladoException e) {
            System.out.println("Erro no cancelamento: " + e.getMessage());
        }
    }
}
