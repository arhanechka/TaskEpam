package ua.kpi.training.model.entity.creators;

import ua.kpi.training.model.entity.flowers.Colour;
import ua.kpi.training.model.entity.flowers.Flower;
import ua.kpi.training.model.entity.flowers.Rose;

/**
 * Created by Anya on 31.05.2017.
 */
public class RoseCreator implements FlowerCreator{
    public Flower createFlower(String name, String receivingDate, double price, double stemLength, Colour colour) {
        return new Rose(name,receivingDate,price,stemLength,colour);
    }


}
