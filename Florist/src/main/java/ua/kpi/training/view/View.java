package ua.kpi.training.view;

import ua.kpi.training.model.entity.purchases.Purchase;
import ua.kpi.training.model.entity.purchases.flowers.Flower;

import java.util.ArrayList;

/**
 * Created by Anya on 31.05.2017.
 */
public class View<T> {
    public void printMessage(T message) {
        System.out.println(message);
    }

    public void printMessage(T... message) {
        for (T t : message) {
            System.out.println(message + " ");
        }
    }

    public void printArrayOfPurchases(ArrayList<T> purchases) {
        for (T purchase : purchases) {
            System.out.println(purchase);
        }
    }

    public void printArrayOfPurchasesWithPrice(ArrayList<Purchase> purchases) {
        for (Purchase purchase : purchases) {
            System.out.println(purchase+" "+purchase.getPrice());
        }
    }
    public void printArrayOfFlowersWithFreshLevel(ArrayList<Flower> bouquet) {
        for (Flower flower : bouquet) {
            System.out.println(flower+" "+flower.getColour()+TextConstants.FRESH_LEVEL+flower.getFreshLevel());
        }
    }
}
