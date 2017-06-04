package ua.kpi.training.model.entity.creators.flowerCreators;

import ua.kpi.training.model.entity.purchases.flowers.*;

/**
 * Created by Anya on 04.06.2017.
 */
public class ConcreteFlowerCreator implements FlowerCreator {
    String WRONG_FLOWER_NAME = "Your flower is not exist. Please choose one in the range";

    @Override
    public Flower createFlower(int whichFlower, String flowerName, String receivingDate, double flowerPrice, double stemLength, Colour flowerColour) {
        switch (whichFlower) {
            case 1: {
                return new Chamomile(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 2: {
                return new Peony(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 3: {
                return new Rose(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            case 4: {
                return new Tulip(flowerName, receivingDate, flowerPrice, stemLength, flowerColour);
            }
            default: {
                System.out.println(WRONG_FLOWER_NAME);
            }
        }
        return null;
    }
}
