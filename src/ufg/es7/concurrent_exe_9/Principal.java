package ufg.es7.concurrent_exe_9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yuri on 30/06/16.
 */
public class Principal {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ContaCorrente contaCorrente = new ContaCorrente(0D);
        Cliente cliente1 = new Cliente(contaCorrente);
        Cliente cliente2 = new Cliente(contaCorrente);
        executor.execute(cliente1);
        executor.execute(cliente2);
        executor.shutdown();
        System.out.println("Saldo final: " + contaCorrente.getSaldo());
    }

}
