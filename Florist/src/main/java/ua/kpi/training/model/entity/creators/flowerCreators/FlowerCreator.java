package ua.kpi.training.model.entity.creators.flowerCreators;

import ua.kpi.training.model.entity.builders.FlowerBuilder;
import ua.kpi.training.model.entity.purchases.flowers.Colour;
import ua.kpi.training.model.entity.purchases.flowers.Flower;

/**
 * Created by Anya on 31.05.2017.
 */
public interface FlowerCreator {
    Flower createFlower(int whichFlower, FlowerBuilder flowerBuilder);

}
