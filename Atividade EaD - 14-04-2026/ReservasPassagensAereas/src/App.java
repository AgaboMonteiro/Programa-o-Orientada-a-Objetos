public class App {
    public static void main(String[] args){

    //Cenário 1: Reserva válida (deve dar SUCESSO);
    ReservaAereaFase1 reserva2 = new ReservaAereaFase1("VOO456", "12345678901", 30, 500.0, 10, false, false, 1000.0);
    System.out.println(reserva2.reservar());

    //Cenário 2: Reserva com saldo insuficiente;
    ReservaAereaFase1 reserva3 = new ReservaAereaFase1("VOO789", "12345678901", 30, 1500.0, 10, false, false, 1000.0);
    System.out.println(reserva3.reservar());

    //Cenário 3: Reserva com idade inválida (menor de idade);
    ReservaAereaFase1 reserva4 = new ReservaAereaFase1("VOO012", "12345678901", 15, 500.0, 10, false, false, 1000.0);
    System.out.println(reserva4.reservar());

    //Cenário 4: Reserva internacional sem visto;
    ReservaAereaFase1 reserva5 = new ReservaAereaFase1("VOO345", "12345678901", 30, 500.0, 10, true, false, 1000.0);
    System.out.println(reserva5.reservar());

    //Cenário 5: Reserva com assento esgotado;
    ReservaAereaFase1 reserva6 = new ReservaAereaFase1("VOO678", "12345678901", 30, 500.0, 0, false, false, 1000.0);
    System.out.println(reserva6.reservar());

    // Cenário 6: Tentar fazer 4 reservas com o mesmo CPF (limite = 3) 
    ReservaAereaFase1.limparReservas();
    String cpf = "66666666666";
    System.out.println("Cenário 6 (Limite por CPF):");
    for (int i = 1; i <= 4; i++) {
        ReservaAereaFase1 r = new ReservaAereaFase1("V6", cpf, 30, 100.0, 10, false, false, 1000.0);
        System.out.println("  Reserva " + i + ": " + r.reservar());
        }
    }
}

