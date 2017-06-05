package ua.kpi.training.model.entity.creators.accessoriesCreators;

import ua.kpi.training.model.entity.builders.AccessoryBuilder;
import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.accessories.Cover;
import ua.kpi.training.model.entity.purchases.accessories.Decoration;
import ua.kpi.training.model.entity.purchases.accessories.Ribbon;

/**
 * Created by Anya on 04.06.2017.
 */
public class ConcreteAccessoryCreator implements AccessoriesCreator {
    String WRONG_ACCESORIES_NAME = "Your accesory is not exist. Please choose one in the range";

    @Override
    public Accessories createAccessories(int whichAccessory, AccessoryBuilder accessoryBuilder) {
        switch (whichAccessory) {
            case 1: {
                return new Cover(accessoryBuilder);
            }
            case 2: {
                return new Ribbon(accessoryBuilder);
            }
            case 3: {
                return new Decoration(accessoryBuilder);
            }
            default: {
                System.out.println(WRONG_ACCESORIES_NAME);
            }
        }
        return null;
    }
}
