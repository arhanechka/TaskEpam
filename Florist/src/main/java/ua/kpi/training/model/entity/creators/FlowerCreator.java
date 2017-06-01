package ua.kpi.training.model.entity.creators;

import ua.kpi.training.model.entity.flowers.Colour;
import ua.kpi.training.model.entity.flowers.Flower;

/**
 * Created by Anya on 31.05.2017.
 */
public interface FlowerCreator {
    Flower createFlower(String name, String receivingDate, double price, double stemLength, Colour colour);

}
