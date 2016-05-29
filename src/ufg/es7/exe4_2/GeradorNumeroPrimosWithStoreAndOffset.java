package ufg.es7.exe4_2;

/**
 * Created by Yuri on 12-May-16.
 */
public class GeradorNumeroPrimosWithStoreAndOffset implements Runnable {

    private int maxToCalculate;

    private int inicio;

    private long executionTime;

    private int maxOffset;

    private PrimeListStorage storage;

    private int stepOffset;

    public GeradorNumeroPrimosWithStoreAndOffset(int inicio, int
            maxToCalculate, int offset, PrimeListStorage storage) {
        this.maxToCalculate = maxToCalculate;
        this.inicio = inicio;
        this.maxOffset = maxToCalculate - inicio;
        this.stepOffset = offset;
        this.storage = storage;
        this.executionTime = 0;
    }

    @Override
    public void run() {
        long before = System.currentTimeMillis();
        for (int i = this.inicio; i < this.maxToCalculate; i += this.stepOffset) {
            //System.out.println("Calculando " + i + " começo: " + this.inicio);
            if (isPrimo(i)) {
                storage.addPrimo(i);
            }
        }
        long after = System.currentTimeMillis();
        this.executionTime = after - before;
    }

    public boolean isPrimo(int number) {
        if (number <= 1)
            return false;
        else if (number <= 3)
            return true;
        else if (number % 2 == 0 || number % 3 == 0)
            return false;
        int temp = 5;
        while ((temp * temp) <= number) {
            if (number % temp == 0 || number % (temp + 2) == 0)
                return false;
            temp += 6;
        }
        return true;
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
        return storage.getPrimos();
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }
}
