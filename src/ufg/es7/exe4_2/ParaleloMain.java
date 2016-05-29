package ufg.es7.exe4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuri on 12-May-16.
 */
public class ParaleloMain {

    public static final int MAX_ELEMENTS = 1000000;
    public static final int NUM_THREADS = 8;

    public static void main(String[] args) throws InterruptedException {
        int[] primes = new int[MAX_ELEMENTS];
        PrimeListStorage storage = new PrimeListStorage(primes);

        List<Thread> threads = new ArrayList<>();
        List<GeradorNumeroPrimosWithStoreAndOffset> geradores = new
                ArrayList<>();
        long before = System.currentTimeMillis();
        for (int i = 1; i <= NUM_THREADS; i++) {
            GeradorNumeroPrimosWithStoreAndOffset gerador = new
                    GeradorNumeroPrimosWithStoreAndOffset(i,
                    MAX_ELEMENTS, NUM_THREADS, storage);
            Thread executor = new Thread(gerador);
            executor.start();
            threads.add(executor);
            geradores.add(gerador);
        }
        for (Thread thread: threads)  {
            thread.join();
        }
        long after = System.currentTimeMillis();
        long result = after - before;

        System.out.println("Tempo total de execução: " + result);

        for (GeradorNumeroPrimosWithStoreAndOffset gerador: geradores) {
            System.out.println("Tempo da thread" + gerador.getInicio() +": "
                    +gerador.getExecutionTime());
        }

        //storage.printPrimes();
    }

}
