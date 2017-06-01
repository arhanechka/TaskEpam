package ua.kpi.training.model.entity.creators.accessoriesCreators;

import ua.kpi.training.model.entity.purchases.accessories.Accessories;

/**
 * Created by Anya on 01.06.2017.
 */
public interface AccessoriesCreator {
    Accessories createAccessories(String name, double price);
}
