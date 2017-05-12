package ua.kpi.company;

import java.util.ArrayList;

/**
 * Created by Anya on 11.05.2017.
 */
public class Model {
    private int numberForGuess;
    private int min;
    private int max;
    ArrayList<Integer> numbersList = new ArrayList<>();

    public int getNumberForGuess() {
        return numberForGuess;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public ArrayList<Integer> getNumbersList() {
        return numbersList;
    }

    public void setRandomValue() {
        setMin(0);
        setMax(100);
        numberForGuess = (int) (Math.random() * max + 1);
    }

    public void setRandomValue(int min, int max) {
        setMin(min);
        setMax(max);
        numberForGuess = (int) (Math.random() * (max - min + 1)) + min;
    }
}
