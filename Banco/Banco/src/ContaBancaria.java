//A classe ContaBancaria com os atributos: numero, titular, saldo e ativa.

//Crie as seguintes exceções personalizadas:
//SaldoInsuficienteException (checked)
//ContaInativaException (checked)
//ValorInvalidoException (unchecked)

public class ContaBancaria{
    private int numero;
    private String titular;
    private double saldo;
    private boolean ativa;

    public ContaBancaria(int numero, String titular){
        this.numero = numero;
        this.titular = titular;
        this.saldo = 200;
        this.ativa = true;
    }

    public void sacar(double valor) throws ContaInativaException, SaldoInsuficienteException{
        if (valor <=0)
            throw new ValorInvalidoException("Valor não permitido!");
        if (!this.ativa)
            throw new ContaInativaException("Conta inativa");
        if(valor > this.saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }

    public void depositar (double valor){
        if (valor <=0)
            throw new ValorInvalidoException("Valor não permitido!");
        this.saldo = this.saldo + valor;
    }



    



}