package ufg.es7.deadlock.cincodemaio;

/**
 * Created by Yuri on 05-May-16.
 */
public class Cliente extends Thread {

    private String nome;

    private Caixa caixa;

    public Cliente(String nome, Caixa caixa) {
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
            try {
                caixa.atender(this, 1, 200);
                Thread.sleep((int) (Math.random() * 1000));
                caixa.atender(this, -1, 50);
                Thread.sleep((int) (Math.random() * 1000));
                caixa.atender(this, 1, 20);
                Thread.sleep((int) (Math.random() * 1000));
                caixa.atender(this, -1, 170);
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
