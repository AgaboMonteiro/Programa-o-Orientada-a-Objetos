public abstract class RelatorioTemplate {

    // método template (define o algoritmo)
    public final void gerar() {
        abrirConexao();
        extrairDados();
        formatarDados();
        fecharConexao();
    }

    protected void abrirConexao() {
        System.out.println("Abrindo conexão...");
    }

    // passos que variam
    protected abstract void extrairDados();
    protected abstract void formatarDados();

    protected void fecharConexao() {
        System.out.println("Fechando conexão...");
    }
}