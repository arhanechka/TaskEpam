package ua.kpi.training.model.entity.purchases.accessories;

import ua.kpi.training.model.entity.purchases.Purchase;

/**
 * Created by Anya on 01.06.2017.
 */
public class Accessories implements Purchase {
    private String name;
    private double price;

    public Accessories(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName();
    }
}
