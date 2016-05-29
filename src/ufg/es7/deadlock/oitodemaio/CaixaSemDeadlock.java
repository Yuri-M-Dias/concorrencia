package ufg.es7.deadlock.oitodemaio;

/**
 * Created by Yuri on 08-May-16.
 */
public class CaixaSemDeadlock {
    double saldoCaixa = 0.0;
    //Useless for now.
    ClienteSemDeadlock clienteDaVez = null;

    public synchronized void sacar(ClienteSemDeadlock c, double valor) throws
            InterruptedException {
        while (saldoCaixa <= valor) {
            wait();
        } //espera saldo, vez
        //System.out.println("Sacando " + valor + " pelo cliente " + c.getNome
                //());
        if (valor > 0) {
            saldoCaixa -= valor;
            clienteDaVez = null;
            notifyAll();
        }
    }

    public synchronized void depositar(ClienteSemDeadlock c, double valor) {
        //System.out.println("Depositando " + valor + " pelo cliente " + c
                //.getNome());
        if (valor > 0) {
            saldoCaixa += valor;
            clienteDaVez = null;
            notifyAll();
        }
    }
}
