package ua.kpi.company;

import java.util.ArrayList;

/**
 * Created by Anya on 11.05.2017.
 */
public class Model {
    private int randomWinNumber;
    private int minBorderOfRange;
    private int maxBorderOfRange;
    ArrayList<Integer> listOfPreviousNumbers = new ArrayList<>();

    public int getrandomWinNumber() {
        return randomWinNumber;
    }

    public void setMinBorderOfRange(int minBorderOfRange) {
        this.minBorderOfRange = minBorderOfRange;
    }

    public void setmaxBorderOfRange(int maxBorderOfRange) {
        this.maxBorderOfRange = maxBorderOfRange;
    }

    public int getminBorderOfRange() {
        return minBorderOfRange;
    }

    public int getmaxBorderOfRange() {
        return maxBorderOfRange;
    }

    public ArrayList<Integer> getlistOfPreviousNumbers() {
        return listOfPreviousNumbers;
    }

    public void setRandomValue() {
        setMinBorderOfRange(0);
        setmaxBorderOfRange(100);
        randomWinNumber = (int) (Math.random() * maxBorderOfRange + 1);
    }

    public void setRandomValue(int minBorderOfRange, int maxBorderOfRange) {
        setMinBorderOfRange(minBorderOfRange);
        setmaxBorderOfRange(maxBorderOfRange);
        randomWinNumber = (int) (Math.random() * (maxBorderOfRange - minBorderOfRange + 1)) + minBorderOfRange;
    }
    public void setOfRange(int number) {
        if (number < getrandomWinNumber()) {
            setMinBorderOfRange(number);
        } else if (number > getrandomWinNumber()) {
            setmaxBorderOfRange(number);
        }
    }

    public boolean isTrueRange (int number){
        if (number<getminBorderOfRange() || number >getmaxBorderOfRange()) {
            return false;
        }
        return true;
    }
}
