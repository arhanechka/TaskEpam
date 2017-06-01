package ua.kpi.training.model;

import ua.kpi.training.model.entity.creators.flowerCreators.*;
import ua.kpi.training.model.entity.purchases.CatalogPurchases;
import ua.kpi.training.model.entity.purchases.flowers.Colour;
import ua.kpi.training.model.entity.purchases.flowers.Flower;

import java.util.*;

/**
 * Created by Anya on 31.05.2017.
 */
public class ModelFlower {
    ResourceBundle rb = ResourceBundle.getBundle("catalog");
    String flowersFileName = rb.getString("flower_price");
    CatalogPurchases catalogFlowers = new CatalogPurchases(flowersFileName);

    String WRONG_FLOWER_NAME = "Your flower is not exist. Please choose one in the range";


    private Colour chooseColour(int choosenColour) {
        switch (choosenColour) {
            case 1:
                return Colour.RED;
            case 2:
                return Colour.BLUE;
            case 3:
                return Colour.YELLOW;
            case 4:
                return Colour.WHITE;
            case 5:
                return Colour.ORANGE;
            case 6:
                return Colour.PINK;
        }
        return Colour.PURPLE;
    }

    public Flower checkFlowerName(int choosenFlower, int choosenColour) {
        FlowerCreator flowerCreator;
        String[] flowerAttributes = catalogFlowers.getCatalog().get(choosenFlower);
        String flowerName = flowerAttributes[0];
        String receivingDate = flowerAttributes[1];
        double flowerPrice = Double.parseDouble(flowerAttributes[2]);
        double stemLength = Double.parseDouble(flowerAttributes[3]);
        Colour flowerColour = chooseColour(choosenColour);
        switch (choosenFlower) {
            case 1: {
                flowerCreator = new ChamomileCreator();
                return flowerCreator.createFlower(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 2: {
                flowerCreator = new PeonyCreator();
                return flowerCreator.createFlower(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 3: {
                flowerCreator = new RoseCreator();
                return flowerCreator.createFlower(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 4: {
                flowerCreator = new TulipCreator();
                return flowerCreator.createFlower(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            default: {
                System.out.println(WRONG_FLOWER_NAME);
            }
        }
        return null;
    }

    public String bouquetPrice(ArrayList<Flower> bouquet) {
        double fullCost = 0;
        for (Flower flower : bouquet) {
            fullCost += flower.getPrice();
        }
        return String.format("%.2f", fullCost);
    }

    public void sortByFresh(ArrayList<Flower> bouquet) {
        Collections.sort(bouquet, compare);
    }

    public static final Comparator<Flower> compare = new Comparator<Flower>() {
        public int compare(Flower flower1, Flower flower2) {
            return Double.compare(flower1.getFreshLevel(), flower2.getFreshLevel());
        }
    };

    public ArrayList<Flower> searchStemLength(ArrayList<Flower> bouquet, double lowBound, double upperBound) {
        ArrayList<Flower> flowersWithNeededStems = new ArrayList<Flower>();
        for (Flower flower : bouquet) {
            double length = flower.getStemLength();
            if (length >= lowBound && length <= upperBound)
                flowersWithNeededStems.add(flower);
        }
        return flowersWithNeededStems;
    }
}
