package ufg.es7.quebrar_md5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Yuri on 28-May-16.
 */
public class QuebrarMD5Paralelo {

    public static final String QUEBRAR = "17a0a00212dde12b063af7dc22fdf02b";
    // Ideal with 4 or 8! Just don't use odd numbers!
    public static final int NUM_THREADS = 4;// Use apenas pares, por favor

    public static void main(String[] args) throws InterruptedException {
        char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyz"
                .toCharArray();
        // Mapa para facilitar a geração de palavras
        List<Character> alphabetList = IntStream
                .range(0, alphabet.length)
                .mapToObj(i -> alphabet[i])
                .collect(Collectors.toList());
        List<Thread> threads = new ArrayList<>();
        List<TestaSubset> subsets = new ArrayList<>();
        Storage storage = new Storage();
        List<List<Character>> partialLists = new ArrayList<>();
        int numberOfCharsPerThread = alphabetList.size() / NUM_THREADS;
        for (int i = 0; i < alphabetList.size(); i += numberOfCharsPerThread) {
            List<Character> listicle = alphabetList.stream()
                    .skip(i).limit(numberOfCharsPerThread)
                    .collect(Collectors.toList());
            partialLists.add(listicle);
        }
        //partialLists.stream().forEach(System.out::println);
        Iterator<List<Character>> iterator = partialLists.iterator();
        long before = System.currentTimeMillis();
        for (int i = 0; i < partialLists.size(); i++) {
            TestaSubset subset = new TestaSubset(alphabetList, iterator.next(),
                    storage, QUEBRAR);
            Thread executor = new Thread(subset);
            executor.start();
            threads.add(executor);
            subsets.add(subset);
        }
        for (Thread thread: threads)  {
            thread.join();
        }
        long after = System.currentTimeMillis();
        long result = after - before;

        if(!storage.isBroken()){
            System.out.println("Something went wrong there mate...");
        }

        System.out.println("Tempo total para quebra: " + result);
    }
}
