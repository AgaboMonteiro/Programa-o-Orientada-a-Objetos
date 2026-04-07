public class App {
    public static void main(String[] args) throws Exception {
        ContaBancaria c1 = new ContaBancaria(123456, "Agabo Monteiro");
        try {
            c1.sacar(200);
        } catch ( SaldoInsuficienteException erro) {
            System.out.println(erro.getMessage());
        }
        catch (ContaInativaException erro){
            System.out.println(erro.getMessage());
        }
        catch (ValorInvalidoException erro){
            System.out.println(erro.getMessage());
        }
        finally{
            System.out.println("Programa encerrado");
        }


    }
}
