package ua.kpi.training.model.entity.creators.accessoriesCreators;

import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.accessories.Ribbon;

/**
 * Created by Anya on 01.06.2017.
 */
public class RibbonCreator implements AccessoriesCreator {
    public Accessories createAccessories(String name, double price) {
        return new Ribbon(name, price);
    }
}
