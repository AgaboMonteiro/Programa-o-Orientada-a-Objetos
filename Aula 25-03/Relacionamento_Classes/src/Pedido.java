public class Pedido {

    private Cliente cliente;

    public Pedido (Cliente messi){
        this.cliente = messi;
    }

    public void mostrarCliente(){
        System.out.println("Cliente " +cliente.getNome());
    }
    
}


//Pedido tem um cliente