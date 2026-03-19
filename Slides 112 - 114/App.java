import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.nome("Monitor");
        p1.preco(1500.00);

        Produto p2 = new Produto();
        p2.nome("Notebook");
        p2.preco(2500.00);

        System.out.println("Produto: " + p1.getNome() + ", Preço: R$ " + p1.getPreco());        
        System.out.println("Produto: " + p2.getNome() + ", Preço: R$ " + p2.getPreco());


        Aluno aluno1 = new Aluno("Maria", 9.5f);//usando o construtor
        Aluno aluno2 = new Aluno("João", 8.5f);
        Aluno aluno3 = new Aluno("José", 7.5f);
        System.out.println("Aluno: " + aluno1.getNome() + ", Nota: " + aluno1.getNota());
        System.out.println("Aluno: " + aluno2.getNome() + ", Nota: " + aluno2.getNota());
        System.out.println("Aluno: " + aluno3.getNome() + ", Nota: " + aluno3.getNota());

        /*11. Na main, crie array de Animal, coloque Cachorro e Gato, percorra e
        chame o método emitirSom(). */
        Animal[] animais = new Animal[]{new Cachorro(), new Gato()}; //polimorfismo, o array é do tipo Animal, mas pode conter objetos de Cachorro e Gato
        for(Animal animal : animais){//percorre o array de animais
            animal.emitirSom();//chama o método emitirSom() de cada animal, o método é sobrescrito em cada classe, então cada animal emite um som diferente
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora:");
        Calculadora calculadora = new Calculadora();
        int opcao;

        do {
            System.out.println("\n1 - Somar dois inteiros;");
            System.out.println("2 - Somar três inteiros;");
            System.out.println("3 - Somar dois números decimais;");
            System.out.println("4 - Subtrair dois números;");
            System.out.println("5 - Multiplicar dois números;");
            System.out.println("6 - Dividir dois números (não permitir divisão por zero);");
            System.out.println("7 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                
                case 1: 
                System.out.print("Digite dois números inteiros: ");
                int numero1 = scanner.nextInt();
                int numero2 = scanner.nextInt();
                int r = calculadora.somar(numero1,numero2);
                System.out.println("Resultado: " + r);
                    break;
                
                case 2: 
                System.out.print("Digite três números inteiros: ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();
                
                int re = calculadora.somar(num1,num2,num3);
                System.out.println("Resultado: " + re);
                    break;
                
                case 3: 
                System.out.print("Digite dois números decimais: ");
                scanner.nextLine();
                double num1s = scanner.nextDouble();
                scanner.nextLine();
                double num2s = scanner.nextDouble();
                
                double res = calculadora.somar(num1s, num2s);
                System.out.println("Resultado: " + res);
                    break;

                case 4: 
                System.out.print("Digite dois números: ");
                double num1su = scanner.nextDouble();
                double num2su = scanner.nextDouble(); 

                double resp = calculadora.subtrair(num1su, num2su);
                System.out.println("Resultado: " + resp);
                    break;
                
                case 5: 
                System.out.print("Digite dois números: ");
                double num1m = scanner.nextDouble();
                double num2m = scanner.nextDouble(); 

                double respo = calculadora.multiplicar(num1m, num2m);
                System.out.println("Resultado: " + respo);
                    break;
                
                case 6: 
                System.out.print("Digite dois números: ");
                double num1d = scanner.nextDouble();
                double num2d = scanner.nextDouble(); 

                double respos = calculadora.dividir(num1d,num2d);
                System.out.println("Resultado: " + respos);
                
                    break;
                
                case 7:
                    System.out.println("Saindo...");    
        } 
    } while (opcao != 7);

        scanner.close();
    }
}
