package ufg.es7.filosofos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Mesa {
    private static final int NUM_FILOSOFOS = 5;// ímpares bons!
    private static final int TEMPO_MAXIMO = 1000 * 10;
    private static List<Garfo> listaGarfos = new ArrayList<>();
    private static List<Filosofo> listaFilosofos = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            //Um garfo por filósofo.
            listaGarfos.add(i, new Garfo(i));
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Garfo garfoEsquerda = listaGarfos.get(i);
            // Pega sempre o garfo a sua
            Garfo garfoDireita = listaGarfos.get((i + 1) % NUM_FILOSOFOS);
            Filosofo filosofo = new Filosofo(i, garfoEsquerda, garfoDireita);
            listaFilosofos.add(filosofo);
            executor.execute(filosofo);
        }
        //Espera um tempo determinado com o programa rodando.
        Thread.sleep(TEMPO_MAXIMO);
        System.out.println("====Chega de comilança!====");
        //Forçando eles a ficarem "cheios"
        listaFilosofos.forEach(filosofo -> filosofo.setCheio());
        //Espera todos terminarem
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        listaFilosofos.forEach(filosofo -> {
            System.out.println("Filósofo " + filosofo + " comeu "
                    + filosofo.getNumeroTurnos() + " vezes");
        });
    }

}
