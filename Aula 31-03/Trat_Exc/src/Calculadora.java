public class Calculadora{
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int resultado = a / b; // Isso vai lançar ArithmeticException
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não é permitida!");
            System.out.println("Mensagem da JVM " + e.getMessage());
        } finally{
            System.out.println("Bloco finally sempre executando");
        }

    System.out.println("Programa continua normalmete...");

    }



}