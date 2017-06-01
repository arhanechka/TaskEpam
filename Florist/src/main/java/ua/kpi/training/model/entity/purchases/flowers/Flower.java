package ua.kpi.training.model.entity.purchases.flowers;

import ua.kpi.training.model.entity.purchases.Purchase;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Anya on 31.05.2017.
 */
public class Flower implements Purchase {
    private String name;
    private int freshLevel;
    private double price;
    private double stemLength;
    private Colour colour;

    public Flower(String name, String receivingDate, double price, double stemLength, Colour colour) {
        setName(name);
        setFreshLevel(receivingDate);
        setPrice(price);
        setStemLength(stemLength);
        setColour(colour);
    }

    public void setFreshLevel(String receiving) {
        Calendar currentDay = new GregorianCalendar();
        currentDay.set(Calendar.MONTH, currentDay.get(Calendar.MONTH) + 1);
        String[] dateArray = receiving.split("\\.");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        Calendar receivingDay = new GregorianCalendar(year, month, day);
        freshLevel = currentDay.get(Calendar.DAY_OF_YEAR) - receivingDay.get(Calendar.DAY_OF_YEAR);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFreshLevel() {
        return freshLevel;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return getName();
    }
}
