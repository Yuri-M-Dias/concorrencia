package ufg.es7.quebrar_md5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Yuri on 19-May-16.
 */
public class QuebrarMD5Serial {

    private static ArrayList<String> hashes;
    private static List<Character> alphabetList;

    static {
        hashes = new ArrayList<>();
        hashes.add("17a0a00212dde12b063af7dc22fdf02b");
        hashes.add("75abfe3020804dd73a2a6040da9df96c");
        hashes.add("c77aeec24015ad7e6e0b1db9d9deed68");
        char[] alphabet = "0123456789abcdefghijklmnopqrstuvwxyz"
                .toCharArray();
        // Mapa para facilitar a geração de palavras
        alphabetList = IntStream
                .range(0, alphabet.length)
                .mapToObj(i -> alphabet[i])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Todas 5 dígitos
        boolean quebrado = false;
        long start = System.currentTimeMillis();
        // Executa enquanto não tiver sido quebrado
        // Horrible nested fors
        for (Character c1 : alphabetList) {
            if (quebrado) break;
            System.out.println("Still running..." + c1);
            for (Character c2 : alphabetList) {
                if (quebrado) break;
                for (Character c3 : alphabetList) {
                    if (quebrado) break;
                    for (Character c4 : alphabetList) {
                        if (quebrado) break;
                        for (Character c5 : alphabetList) {
                            String word = "" + c1 + c2 + c3 + c4 + c5;
                            Boolean achou = testaUmaString(word);
                            if (achou) {
                                long finish = System.currentTimeMillis();
                                long result = finish - start;
                                System.out.println("Em " + result + "!");
                                if (hashes.isEmpty()) {
                                    quebrado = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(!hashes.isEmpty()){
            System.out.println("Não consegui crackear! Ignore o tempo abaixo!");
        }
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Levou: " + result + "ms");
    }

    public static boolean testaUmaString(String word) {
        String wordMD5 = QuebrarMD5Utils
                .encodeMD5(word);
        //System.out.println(word + " | " + wordMD5);
        String achouIgual = hashes.stream()
                .filter(secret -> secret.equals(wordMD5))
                .findFirst()
                .orElse(null);
        if (achouIgual != null && !"".equals
                (achouIgual)) {
            System.out.println("Quebrei: " +
                    achouIgual + " é " + word);
            hashes.remove(achouIgual);
            return true;
        }
        return false;
    }

}
