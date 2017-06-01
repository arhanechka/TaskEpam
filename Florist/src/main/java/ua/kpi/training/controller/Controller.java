package ua.kpi.training.controller;

import ua.kpi.training.model.Model;
import ua.kpi.training.model.entity.flowers.Flower;
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
    Model model;
    ArrayList<Flower> bouquet;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        bouquet = new ArrayList<>();
    }

    public void processFlowerCreation() {
        bouquetCollector();
        view.printArrayOfFlowers(bouquet);
        view.printMessage(TextConstants.FULL_PRICE+model.bouquetPrice(bouquet));
        model.sortByFresh(bouquet);
      //  view.printArrayOfFlowers(bouquet);
        System.out.println("~~~~~~~~~~");
        view.printArrayOfFlowers(model.searchStemLength(bouquet, 21.3, 33.5));
        for (Flower flower : bouquet) {
            System.out.println(flower +" "+flower.getFreshLevel());
        }
    }
    public void bouquetCollector() {
        view.printMessage(TextConstants.FLOWER_CHOOSING);
        try (Scanner scanner = new Scanner(new InputStreamReader(System.in));) {
            int choosenFlower = scanner.nextInt();
            view.printMessage(TextConstants.COLOR_CHOOSING);
            int choosenColour = scanner.nextInt();
            while (choosenFlower != 5) {
                Flower fc = model.checkFlowerName(choosenFlower, choosenColour);
                if (fc != null)
                    bouquet.add(fc);
                view.printMessage(TextConstants.FLOWER_CHOOSING);
                choosenFlower = scanner.nextInt();
                view.printMessage(TextConstants.COLOR_CHOOSING);
                choosenColour = scanner.nextInt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

