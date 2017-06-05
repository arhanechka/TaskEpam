package ua.kpi.training.model.entity.purchases.flowers;

import ua.kpi.training.model.entity.builders.FlowerBuilder;
import ua.kpi.training.model.entity.creators.flowerCreators.FlowerCreator;
import ua.kpi.training.model.entity.purchases.Purchase;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Anya on 31.05.2017.
 */
public class Flower implements Purchase {
    private int freshLevel;
    FlowerBuilder flowerBuilder;

    public Flower(FlowerBuilder flowerBuilder) {
        this.flowerBuilder = flowerBuilder;
        setFreshLevel(flowerBuilder.getReceivingDate());
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
        return flowerBuilder.getName();
    }

    public int getFreshLevel() {
        return freshLevel;
    }


    public double getPrice() {
        return flowerBuilder.getPrice();
    }

    public double getStemLength() {
        return flowerBuilder.getStemLength();
    }

    public Colour getColour() {
        return flowerBuilder.getColour();
    }

    @Override
    public String toString() {
        return getName();
    }
}
