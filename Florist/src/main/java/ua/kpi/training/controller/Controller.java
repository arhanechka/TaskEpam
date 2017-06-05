package ua.kpi.training.controller;

import ua.kpi.training.model.ModelAccessories;
import ua.kpi.training.model.ModelFlower;
import ua.kpi.training.model.ModelPurchase;
import ua.kpi.training.model.entity.purchases.Purchase;
import ua.kpi.training.model.entity.purchases.accessories.Accessories;
import ua.kpi.training.model.entity.purchases.flowers.Flower;
import ua.kpi.training.view.TextConstants;
import ua.kpi.training.view.View;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anya on 31.05.2017.
 */
public class Controller {
    View view;
    ModelFlower modelFlower;
    ModelAccessories modelAccesories;
    ModelPurchase modelPurchase;
    ArrayList<Flower> bouquet;
    ArrayList<Accessories> accesories;
    ArrayList<Purchase> purchases;

    public Controller(View view, ModelFlower modelFlower, ModelAccessories modelAccesories) {
        this.view = view;
        this.modelFlower = modelFlower;
        this.modelAccesories = modelAccesories;
        bouquet = new ArrayList<>();
        accesories = new ArrayList<>();
        purchases = new ArrayList<>();
        this.modelPurchase = ModelPurchase.getInstance();

    }

    public void processFlowerCreation() {
        try (Scanner scanner = new Scanner(new InputStreamReader(System.in));) {
            bouquetCollector(scanner);
            view.printMessage(TextConstants.BOUQUET);
            view.printArrayOfFlowersWithFreshLevel(bouquet);
            view.printMessage(TextConstants.FULL_BOUQUET_PRICE + modelFlower.bouquetPrice(bouquet));
            modelFlower.sortByFresh(bouquet);
            view.printMessage(TextConstants.SORTED_BOUQUET);
            view.printArrayOfFlowersWithFreshLevel(bouquet);
            accesoriesCollector(scanner);
            view.printMessage(TextConstants.ACCESSORIES);
            view.printArrayOfPurchases(accesories);
            view.printMessage(TextConstants.FULL_ACCESSORIES_PRICE + modelAccesories.accessoriesPrice(accesories));
            modelPurchase.setPurchaseArray(bouquet, accesories);
            purchases = modelPurchase.getAllPurchasesArray();
            view.printMessage(TextConstants.PURCHASES);
            view.printArrayOfPurchasesWithPrice(purchases);
            view.printMessage(TextConstants.FULL_PURCHASE_PRICE + modelPurchase.getFullPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bouquetCollector(Scanner scanner) {
        view.printMessage(TextConstants.FLOWER_CHOOSING);
        int choosenFlower = scanner.nextInt();
        view.printMessage(TextConstants.COLOR_CHOOSING);
        int choosenColour = scanner.nextInt();
        while (!isPurchaseComplited(choosenFlower, TextConstants.FLOWERS_NUMBER)) {
            Flower nextFlower = modelFlower.checkFlowerName(choosenFlower, choosenColour);
            if (nextFlower != null)
                bouquet.add(nextFlower);
            view.printMessage(TextConstants.FLOWER_CHOOSING);
            choosenFlower = scanner.nextInt();
            if (!isPurchaseComplited(choosenFlower, TextConstants.FLOWERS_NUMBER)) {
                view.printMessage(TextConstants.COLOR_CHOOSING);
                choosenColour = scanner.nextInt();
            }
        }

    }

    public void accesoriesCollector(Scanner scanner) {
        view.printMessage(TextConstants.ACCESORIES_CHOOSING);
        int choosenAccesory = scanner.nextInt();
        while (!isPurchaseComplited(choosenAccesory, TextConstants.ACCESSORIES_NUMBER)) {
            Accessories nextAccessory = modelAccesories.chooseAccesory(choosenAccesory);
            if (nextAccessory != null)
                accesories.add(nextAccessory);
            view.printMessage(TextConstants.ACCESORIES_CHOOSING);
            choosenAccesory = scanner.nextInt();
        }
    }

    public boolean isPurchaseComplited(int chosenNumber, Integer compare) {
        if (chosenNumber != compare) {
            return false;
        }
        return true;
    }

}


