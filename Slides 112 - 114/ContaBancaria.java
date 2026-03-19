/*8 - Crie classe ContaBancaria com saldo sendo atributo privado e crie
os métodos depositar, sacar, obterSaldo. 
9 - Melhore o Exercício 8 implementando validações para não permitir
saque maior que saldo e depósito negativo.*/

public class ContaBancaria {
    private double saldo;

     public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor){
        if(valor > 0){ //verifica se o valor é positivo, impede depósito negativo
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser positivo.");
        }
    }

    public void sacar(double valor){
        if(valor > 0 && valor <= saldo){ //verifica se o valor é positivo e não excede o saldo. evitando saque maior que o saldo
            saldo -= valor;
        } else {
            System.out.println("Valor de saque inválido. O valor deve ser positivo e não pode exceder o saldo.");
        }
    }

    public double obterSaldo(){
        return saldo;
    }
    
}
