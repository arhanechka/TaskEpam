package ua.kpi.training.model;

import ua.kpi.training.model.entity.creators.accessoriesCreators.AccessoriesCreator;
import ua.kpi.training.model.entity.creators.accessoriesCreators.CoverCreator;
import ua.kpi.training.model.entity.creators.accessoriesCreators.DecorationCreator;
import ua.kpi.training.model.entity.creators.accessoriesCreators.RibbonCreator;
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
    String WRONG_ACCESORIES_NAME = "Your accesory is not exist. Please choose one in the range";

    public Accessories chooseAccesory(int choosenAccesory) {
        AccessoriesCreator accesoriesCreator;
        String[] attributes = catalogAccesories.getCatalog().get(choosenAccesory);
        String accesoryName = attributes[0];
        double accesoryPrice = Double.parseDouble(attributes[1]);
        switch (choosenAccesory) {
            case 1: {
                accesoriesCreator = new CoverCreator();
                return accesoriesCreator.createAccessories(accesoryName, accesoryPrice);
            }
            case 2: {
                accesoriesCreator = new RibbonCreator();
                return accesoriesCreator.createAccessories(accesoryName, accesoryPrice);
            }
            case 3: {
                accesoriesCreator = new DecorationCreator();
                return accesoriesCreator.createAccessories(accesoryName, accesoryPrice);
            }
            default: {
                System.out.println(WRONG_ACCESORIES_NAME);
            }
        }
        return null;
    }

    public String accessoriesPrice(ArrayList<Accessories> accesories) {
        double fullCost = 0;
        for (Accessories ac : accesories) {
            fullCost += ac.getPrice();
        }
        return String.format("%.2f", fullCost);
    }


}
