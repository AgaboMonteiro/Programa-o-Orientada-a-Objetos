class RelatorioCSV extends RelatorioTemplate {

    @Override
    protected void extrairDados() {
        System.out.println("Extraindo dados para CSV...");
    }

    @Override
    protected void formatarDados() {
        System.out.println("Formatando relatório em CSV...");
    }
}