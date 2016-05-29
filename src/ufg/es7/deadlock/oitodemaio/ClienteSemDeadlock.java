package ufg.es7.deadlock.oitodemaio;

/**
 * Created by Yuri on 05-May-16.
 */
public class ClienteSemDeadlock extends Thread {

    private String nome;

    private CaixaSemDeadlock caixa;

    public ClienteSemDeadlock(String nome, CaixaSemDeadlock caixa) {
        this.nome = nome;
        this.caixa = caixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.println("Cliente " + nome + " começou!");
        while (true) {
            long timeBefore = 0;
            long timeAfter = 0;
            try {
                timeBefore = System.currentTimeMillis();
                caixa.depositar(this, 200);
                //Thread.sleep((int) (Math.random() * 1000));
                caixa.sacar(this, 50);
                //Thread.sleep((int) (Math.random() * 1000));
                caixa.depositar(this, 20);
                //Thread.sleep((int) (Math.random() * 1000));
                caixa.sacar(this, 170);
                timeAfter = System.currentTimeMillis();
                //Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long result = timeAfter - timeBefore;
            if (result > 100) {//Pega só se for muito lento
                System.out.println("Took me, " + nome + ", " + result + " to do " +
                        "all " + "operations!");
            }

        }
    }

}
