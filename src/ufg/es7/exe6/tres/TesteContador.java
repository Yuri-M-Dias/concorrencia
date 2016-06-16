package ufg.es7.exe6.tres;

import java.util.ArrayList;
import java.util.List;

public class TesteContador {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Contador umaThread = new Contador();
            Thread thread = new Thread(umaThread);
            thread.start();
        }
    }

}
