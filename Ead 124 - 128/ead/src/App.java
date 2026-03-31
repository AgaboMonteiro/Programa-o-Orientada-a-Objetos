public class App {
    public static void main(String[] args) throws Exception {

        //Instanciando os autores
    Autor autor1 = new Autor("Escritor nacional","Machado de Assis", "Machadao@email.com");
    Autor autor2 = new Autor("Universo", "H.P Lovecraft", "Cosmic@gmail.com");


    //Criação dos livros

    Livro livro1 = new Livro("Dom casmurro",autor1,1899);
    Livro livro2 = new Livro("Coletânea de contos",autor2,1800);

    Leitor leitor1 = new Leitor("12331","Maria Almeida","mariaal@gmail.com");
    Leitor leitor2 = new Leitor("34234","Gabinho","Hbinho@gmail.com");

    //Criando a biblioteca
    Biblioteca biblioteca = new Biblioteca("Biblioteca Do Centro");

    biblioteca.adicionarLivro(livro1);
    biblioteca.adicionarLivro(livro2);

    biblioteca.registrarEmprestimo(livro1,leitor1);
    biblioteca.registrarEmprestimo(livro2,leitor2);

    biblioteca.listarLivros();
    biblioteca.listarEmprestimos();

    

    }
}