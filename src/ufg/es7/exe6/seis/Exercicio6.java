package ufg.es7.exe6.seis;

public class Exercicio6 extends Thread {

    public Exercicio6(String name) {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {
        Exercicio6 a = new Exercicio6("A");
        Exercicio6 b = new Exercicio6("B");
        Exercicio6 c = new Exercicio6("C");
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName());
    }
}
