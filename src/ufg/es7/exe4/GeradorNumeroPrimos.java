package ufg.es7.exe4;

/**
 * Created by Yuri on 12-May-16.
 */
public class GeradorNumeroPrimos implements Runnable {

    private int maxToCalculate;

    private int inicio;

    private int[] primos;

    private long executionTime;

    private int maxOffset;

    public GeradorNumeroPrimos(int inicio, int maxToCalculate) {
        this.maxToCalculate = maxToCalculate;
        this.inicio = inicio;
        this.maxOffset = maxToCalculate - inicio;
        this.primos = new int[maxOffset];
        this.executionTime = 0;
    }

    @Override
    public void run() {
        long before = System.currentTimeMillis();
        for (int i = this.inicio, j = 0; i < this.maxToCalculate; i++) {
            if(isPrimo(i)) {
                this.primos[j] = i;
                j++;
            }
        }
        long after = System.currentTimeMillis();
        this.executionTime = after - before;
    }

    public boolean isPrimo(int number){
        if(number <= 1)
            return false;
        else if (number <= 3)
            return true;
        else if (number % 2 == 0 || number % 3 == 0)
            return false;
        int temp = 5;
        while((temp * temp) <= number){
            if(number % temp == 0 || number % (temp + 2) == 0)
                return false;
            temp += 6;
        }
        return true;
    }

    public void printNNPrimes(){
        for (int i = 0; i < this.maxOffset; i++) {
            int primo = this.primos[i];
            if(primo != 0){
                System.out.println(primo);
            }
        }

    }

    public int getMaxToCalculate() {
        return maxToCalculate;
    }

    public void setMaxToCalculate(int maxToCalculate) {
        this.maxToCalculate = maxToCalculate;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int[] getPrimos() {
        return primos;
    }

    public void setPrimos(int[] primos) {
        this.primos = primos;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
