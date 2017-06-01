package ua.kpi.training.view;

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
}
