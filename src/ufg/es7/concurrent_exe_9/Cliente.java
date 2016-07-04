package ufg.es7.concurrent_exe_9;

/**
 * Created by yuri on 30/06/16.
 */
public class Cliente implements Runnable {

    private ContaCorrente conta;

    public Cliente(ContaCorrente conta) {
        this.conta = conta;
    }

    @Override
    public void run() {
        double valorDefault = 200;
        conta.depositor(valorDefault);
        conta.depositor(valorDefault);
        conta.depositor(valorDefault);
        conta.depositor(valorDefault);
        conta.depositor(valorDefault);
        conta.depositor(valorDefault);
        conta.sacar(valorDefault);
        conta.sacar(valorDefault);
        conta.sacar(valorDefault);
        conta.sacar(valorDefault);
        conta.sacar(valorDefault);
    }
}
