package ua.kpi.training.model;

import ua.kpi.training.model.entity.builders.AccessoryBuilder;
import ua.kpi.training.model.entity.creators.accessoriesCreators.*;
import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.CatalogPurchases;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Anya on 01.06.2017.
 */
public class ModelAccessories {
    ResourceBundle rb = ResourceBundle.getBundle("catalog");
    String accesoriesFileName = rb.getString("accesories_price");
    CatalogPurchases catalogAccesories = new CatalogPurchases(accesoriesFileName);
    AccessoryBuilder accessoryBuilder;

    public Accessories chooseAccesory(int choosenAccesory) {
        AccessoriesCreator accesoriesCreator;
        String[] attributes = catalogAccesories.getCatalog().get(choosenAccesory);
        String accesoryName = attributes[0];
        double accesoryPrice = Double.parseDouble(attributes[1]);
        accessoryBuilder = new AccessoryBuilder(accesoryName, accesoryPrice);
        accesoriesCreator = new ConcreteAccessoryCreator();
        return accesoriesCreator.createAccessories(choosenAccesory, accessoryBuilder);
    }

    public String accessoriesPrice(ArrayList<Accessories> accesories) {
        double fullCost = 0;
        for (Accessories ac : accesories) {
            fullCost += ac.getPrice();
        }
        return String.format("%.2f", fullCost);
    }


}
