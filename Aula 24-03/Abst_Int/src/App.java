public class App {
    public static void main(String[] args) {
        Cachorro c = new Cachorro("Nome_do_Cachorro");
        c.emitirSom();

        Pato p = new Pato("Nome_do_Pato");
        p.emitirSom();
        p.nadar();
        p.voar();

        Passaro pa = new Passaro("Nome_do_Pato");
        pa.emitirSom();
        pa.voar();

        Peixe pe = new Peixe("Nome_do_Peixe");
        pe.emitirSom();
        pe.nadar();

        Aviao a = new Aviao ("Marca_avião", "Cor_avião", 200);
        a.voar();


    }
    
}
