public class App {
    public static void main(String[] args) {

        // =========================
        // 1) OBSERVER
        // =========================
        System.out.println("=== OBSERVER ===");

        EstacaoClimatica estacao = new EstacaoClimatica();

        DisplayAtual d1 = new DisplayAtual("Display 1");
        DisplayAtual d2 = new DisplayAtual("Display 2");

        estacao.adicionar(d1);
        estacao.adicionar(d2);

        estacao.setMedidas(25, 60, 1013);
        estacao.setMedidas(30, 40, 1008);


        // =========================
        // 2) TEMPLATE METHOD
        // =========================
        System.out.println("\n=== TEMPLATE METHOD ===");

        RelatorioTemplate pdf = new RelatorioPDF();
        RelatorioTemplate csv = new RelatorioCSV();

        pdf.gerar();
        csv.gerar();


        // =========================
        // 3) ADAPTER
        // =========================
        System.out.println("\n=== ADAPTER ===");

        AreaCalculavel retangulo = new RetanguloAdapter(5, 10);
        System.out.println("Área do retângulo: " + retangulo.calcularArea());


        // =========================
        // 4) DECORATOR
        // =========================
        System.out.println("\n=== DECORATOR ===");

        Sanduiche s = new SanduicheSimples();
        s = new Queijo(s);
        s = new Bacon(s);
        s = new Tomate(s);

        System.out.println("Pedido: " + s.getDescricao());
        System.out.println("Preço: R$ " + s.getPreco());
    }
}