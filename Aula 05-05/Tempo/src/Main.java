import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {


    public static final int TAMANHO = 1000000;


    public static void main(String[] args) {


        //ArrayList
        long inicioArray = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < TAMANHO; i++)
            arrayList.add(i);


        for (Integer valor : arrayList) {
            // Apenas percorrendo
        }
        long fimArray = System.currentTimeMillis();


        // LinkedList
        long inicioLinked = System.currentTimeMillis();
        List<Integer> linkedList = new LinkedList<>();
        // Inserção dos elementos
        for (int i = 0; i < TAMANHO; i++)
            linkedList.add(i);

        for (Integer valor : linkedList) {
            // Apenas percorrendo
        }
        long fimLinked = System.currentTimeMillis();


        // Calculando o tempo total em segundos
        double tempoArray = (fimArray - inicioArray) / 1000.0;
        double tempoLinked = (fimLinked - inicioLinked) / 1000.0;


        System.out.println("Tempo total ArrayList: " + tempoArray + " s");
        System.out.println("Tempo total LinkedList: " + tempoLinked + " s");
    }
}
