package ufg.es7;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MinhaThread t1 = new MinhaThread();
        MinhaThread t2 = new MinhaThread();
        MinhaThread t3 = new MinhaThread();
        System.out.println("Inicio main");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Fim main");
    }

}
