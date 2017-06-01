package ua.kpi.training.model.entity.purchases;

/**
 * Created by Anya on 01.06.2017.
 */
public interface Purchase {
    public void setName(String name);

    public String getName();

    public void setPrice(double price);

    public double getPrice();
}
