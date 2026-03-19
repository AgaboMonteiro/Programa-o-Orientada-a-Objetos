/*12. Crie uma classe Calculadora que implemente diferentes operações
matemáticas utilizando sobrecarga de métodos:
a. Somar dois inteiros;
b. Somar três inteiros;
c. Somar dois números decimais;
d. Subtrair dois números;
e. Multiplicar dois números;
f. Dividir dois números (não permitir divisão por zero).
g. A classe main deverá permitir a entrada de dados pelo usuário com um menu
apresentando as opções disponíveis. */
public class Calculadora {
    public int somar(int a, int b){
       return  a + b;
    }

    public int somar(int a, int b, int c){
        return a + b + c;
    }

    public double somar(double a, double b){
        return a + b;
    }
    public double subtrair(double a, double b){
        return a - b;
    }

    public double multiplicar(double a, double b){
        return a* b;
    }

    public double dividir(double a, double b){
        if (b==0){
            System.out.println("Divisão por zero não é permitida.");
            return 0; //retorna 0 ou poderia lançar uma exceção
        }
        return a / b;
    }    
}
