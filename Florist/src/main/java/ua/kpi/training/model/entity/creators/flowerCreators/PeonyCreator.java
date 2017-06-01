package ua.kpi.training.model.entity.creators.flowerCreators;

import ua.kpi.training.model.entity.purchases.flowers.Colour;
import ua.kpi.training.model.entity.purchases.flowers.Flower;
import ua.kpi.training.model.entity.purchases.flowers.Peony;

/**
 * Created by Anya on 31.05.2017.
 */
public class PeonyCreator implements FlowerCreator {
    public Flower createFlower(String name, String receivingDate, double price, double stemLength, Colour colour) {
        return new Peony(name, receivingDate, price, stemLength, colour);
    }


}
