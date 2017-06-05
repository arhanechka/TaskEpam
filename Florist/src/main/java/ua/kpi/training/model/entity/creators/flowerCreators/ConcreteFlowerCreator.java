package ua.kpi.training.model.entity.creators.flowerCreators;

import ua.kpi.training.model.entity.builders.FlowerBuilder;
import ua.kpi.training.model.entity.purchases.flowers.*;

/**
 * Created by Anya on 04.06.2017.
 */
public class ConcreteFlowerCreator implements FlowerCreator {
    String WRONG_FLOWER_NAME = "Your flower is not exist. Please choose one in the range";

    @Override
    public Flower createFlower(int whichFlower, FlowerBuilder flowerBuilder) {
        switch (whichFlower) {
            case 1: {
                return new Chamomile(flowerBuilder);
            }
            case 2: {
                return new Peony(flowerBuilder);
            }
            case 3: {
                return new Rose(flowerBuilder);
            }
            case 4: {
                return new Tulip(flowerBuilder);
            }
            default: {
                System.out.println(WRONG_FLOWER_NAME);
            }
        }
        return null;
    }
}
