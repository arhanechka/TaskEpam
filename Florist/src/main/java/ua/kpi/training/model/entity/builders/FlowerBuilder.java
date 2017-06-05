package ua.kpi.training.model.entity.builders;

import ua.kpi.training.model.entity.purchases.flowers.Colour;

/**
 * Created by Anya on 05.06.2017.
 */
public class FlowerBuilder implements Builder{
    private String name;
    private String receivingDate;
    private double price;
    private double stemLength;
    private Colour colour;

    public FlowerBuilder(String name, String receivingDate, double price, double stemLength, Colour colour) {
        setName(name);
        setReceivingDate(receivingDate);
        setPrice(price);
        setStemLength(stemLength);
        setColour(colour);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
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
}
