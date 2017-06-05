package ua.kpi.training.model.entity.purchases.accessories;

import ua.kpi.training.model.entity.builders.AccessoryBuilder;
import ua.kpi.training.model.entity.purchases.Purchase;

/**
 * Created by Anya on 01.06.2017.
 */
public class Accessories implements Purchase {
    AccessoryBuilder accessoryBuilder;

    public Accessories(AccessoryBuilder accessoryBuilder) {
        this.accessoryBuilder = accessoryBuilder;
    }

    public String getName() {
        return accessoryBuilder.getName();
    }

    @Override
    public double getPrice() {
        return accessoryBuilder.getPrice();
    }

    @Override
    public String toString() {
        return getName();
    }
}
