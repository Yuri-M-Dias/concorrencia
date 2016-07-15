package ufg.es7.prova_2.questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CorridaTartarugas {

    private static List<Tartaruga> tartarugasFinalizadoras = new ArrayList<>();
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final int TAMANHO_PISTA = 300;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 7; i++) {
            Tartaruga tartaruga = new Tartaruga(TAMANHO_PISTA, String.valueOf
                    (i));
            executor.execute(tartaruga);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        //Todas terminaram de rodar
        Tartaruga vencedora = tartarugasFinalizadoras.get(0);
        System.out.println("Tartaruga " + vencedora.getNome() + " é a " +
                "vencedora, com " + vencedora.getPassos() + " passos!");
        for (int i = 1; i < 7; i++) {
            Tartaruga tartaruga = tartarugasFinalizadoras.get(i);
            System.out.println("Na posição " + (i + 1) + " temos a tartaruga " +
                    tartaruga.getNome() + " com " + tartaruga.getPassos() +
                    " passos!");
        }
        System.out.println("Fim da corrida!");
    }


    public static void adicionaLista(Tartaruga tartaruga) {
        tartarugasFinalizadoras.add(atomicInteger.getAndIncrement(), tartaruga);
    }

}
