package ufg.es7.exe4_2;

/**
 * Created by Yuri on 17-May-16.
 */
public class PrimeListStorage {

    private int[] primos;

    private int index;

    public PrimeListStorage(int[] primos) {
        this.primos = primos;
        this.index = 0;
    }

    public synchronized void addPrimo(int number){
        if(number > 0){
            this.primos[this.index] = number;
            index++;
        }
    }

    public void printPrimes(){
        for (int i = 0; i < index; i++) {
            System.out.println("Prime: " + this.primos[i]);
        }
    }

    public int[] getPrimos() {
        return primos;
    }

    public void setPrimos(int[] primos) {
        this.primos = primos;
    }
}
