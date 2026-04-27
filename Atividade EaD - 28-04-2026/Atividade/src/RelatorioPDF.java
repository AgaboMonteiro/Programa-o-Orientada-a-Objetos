class RelatorioPDF extends RelatorioTemplate {

    @Override
    protected void extrairDados() {
        System.out.println("Extraindo dados para PDF...");
    }

    @Override
    protected void formatarDados() {
        System.out.println("Formatando relatório em PDF...");
    }
}