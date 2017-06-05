package ua.kpi.training.model.entity.builders;

/**
 * Created by Anya on 05.06.2017.
 */
public interface Builder {
    public void setName(String name);
    public void setPrice(double price);
    public String getName();
    public double getPrice();
}
