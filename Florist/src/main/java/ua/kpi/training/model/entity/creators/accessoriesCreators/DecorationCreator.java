package ua.kpi.training.model.entity.creators.accessoriesCreators;

import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.accessories.Decoration;

/**
 * Created by Anya on 01.06.2017.
 */
public class DecorationCreator implements AccessoriesCreator {
    @Override
    public Accessories createAccessories(String name, double price) {
        return new Decoration(name, price);
    }
}
