package ua.kpi.training.model.entity.builders;

/**
 * Created by Anya on 05.06.2017.
 */
public class AccessoryBuilder implements Builder {
    private String name;
    private double price;

    public AccessoryBuilder(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
