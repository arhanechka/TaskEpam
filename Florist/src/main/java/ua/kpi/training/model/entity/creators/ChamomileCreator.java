package ua.kpi.training.model.entity.creators;

import ua.kpi.training.model.entity.flowers.Chamomile;
import ua.kpi.training.model.entity.flowers.Colour;
import ua.kpi.training.model.entity.flowers.Flower;

/**
 * Created by Anya on 31.05.2017.
 */
public class ChamomileCreator implements FlowerCreator {
    public Flower createFlower(String name, String receivingDate, double price, double stemLength, Colour colour) {
        return new Chamomile(name,receivingDate,price,stemLength,colour);
    }


}
