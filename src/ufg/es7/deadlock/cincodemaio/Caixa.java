package ufg.es7.deadlock.cincodemaio;

/**
 * Created by Yuri on 05-May-16.
 */
public class Caixa {
    double saldoCaixa = 0.0;
    Cliente clienteDaVez = null;

    public synchronized void atender(Cliente c, int op, double v) throws InterruptedException {
        while (clienteDaVez != null) {
            wait();
        } //espera vez
        clienteDaVez = c;
        System.out.println("Saldo atual: " + saldoCaixa + " cliente: " +
                clienteDaVez.getNome() + " op: " + op);
        switch (op) {
            case -1:
                sacar(c, v);
                break;
            case 1:
                depositar(c, v);
                break;
        }
    }

    private synchronized void sacar(Cliente c, double valor) throws InterruptedException {
        while (saldoCaixa <= valor) {
            wait();
        } //espera saldo, vez
        if (valor > 0) {
            saldoCaixa -= valor;
            clienteDaVez = null;
            notifyAll();
        }
    }

    private synchronized void depositar(Cliente c, double valor) {
        if (valor > 0) {
            saldoCaixa += valor;
            clienteDaVez = null;
            notifyAll();
        }
    }
}
