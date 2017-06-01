package ua.kpi.training.model;

import ua.kpi.training.model.entity.purchases.Purchase;
import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.flowers.Flower;

import java.util.ArrayList;

/**
 * Created by Anya on 01.06.2017.
 */
public class ModelPurchase {
    ArrayList<Purchase> allPurchasesArray;
    double fullPrice;

    public ModelPurchase() {
        allPurchasesArray = new ArrayList<>();
        fullPrice = 0;
    }

    public void setPurchaseArray(ArrayList<Flower> flowers, ArrayList<Accessories> accessories) {
        this.allPurchasesArray.addAll(flowers);
        this.allPurchasesArray.addAll(accessories);
        setPrice();
    }

    public ArrayList<Purchase> getAllPurchasesArray() {
        return allPurchasesArray;
    }


    public void setPrice() {

        for (Purchase purchase : allPurchasesArray) {
            fullPrice += purchase.getPrice();
        }
    }

    public double getFullPrice() {
        return fullPrice;
    }
}
