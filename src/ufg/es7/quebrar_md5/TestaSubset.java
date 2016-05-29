package ufg.es7.quebrar_md5;

import java.util.List;

/**
 * Testa apenas um subset de começo da lista parcial, como 0-9, a-d e etc.
 * Created by Yuri on 28-May-16.
 */
public class TestaSubset implements Runnable {

    private List<Character> alphabetFull;
    private List<Character> alphabetPartial;
    private Storage storage;
    private String wordToCompare;

    public TestaSubset(List<Character> alphabetFull, List<Character> alphabetPartial, Storage storage, String wordToCompare) {
        this.alphabetFull = alphabetFull;
        this.alphabetPartial = alphabetPartial;
        this.storage = storage;
        this.wordToCompare = wordToCompare;
        System.out.print("Usando: ");
        alphabetPartial.stream().forEach(System.out::print);
        System.out.println("");
    }

    @Override
    public void run() {
        // This is horrible
        for (Character c1 : alphabetPartial) {
            if (storage.isBroken()) break;
            System.out.println(Thread.currentThread().getId() + " still " +
                    "running with " + c1);
            for (Character c2 : alphabetFull) {
                if (storage.isBroken()) break;
                for (Character c3 : alphabetFull) {
                    if (storage.isBroken()) break;
                    for (Character c4 : alphabetFull) {
                        if (storage.isBroken()) break;
                        for (Character c5 : alphabetFull) {
                            String word = "" + c1 + c2 + c3 + c4 + c5;
                            Boolean achou = testaUmaString(word);
                            if (achou) {
                                storage.setBroken();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean testaUmaString(String word) {
        String wordMD5 = QuebrarMD5Utils
                .encodeMD5(word);
        //System.out.println(word + " | " + wordMD5);
        if (this.wordToCompare.equals(wordMD5)) {
            System.out.println("Quebrei: " +
                    this.wordToCompare + " é " + word);
            return true;
        }
        return false;
    }

}
