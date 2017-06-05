package ua.kpi.training.model;

import ua.kpi.training.model.entity.purchases.Purchase;
import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.flowers.Flower;

import java.util.ArrayList;

/**
 * Created by Anya on 01.06.2017.
 */
public class ModelPurchase {
    private static ModelPurchase instance;
    static ArrayList<Purchase> allPurchasesArray;
    static double fullPrice;

    private ModelPurchase() {

    }

    public static ModelPurchase getInstance() {
        if (instance == null) {
            allPurchasesArray = new ArrayList<>();
            fullPrice = 0;
            return new ModelPurchase();
        }
        return instance;
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

    public String getFullPrice() {
        return String.format("%.2f", fullPrice);
    }
}
