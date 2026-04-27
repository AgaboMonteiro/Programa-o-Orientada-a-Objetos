public class DisplayAtual implements Display {

    private String nome;

    public DisplayAtual(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(float t, float u, float p) {
        System.out.println(nome + " -> Temp: " + t +
                " Umidade: " + u +
                " Pressão: " + p);
    }
}