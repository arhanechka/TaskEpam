package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.ModelAccessories;
import ua.kpi.training.model.ModelFlower;
import ua.kpi.training.model.ModelPurchase;
import ua.kpi.training.view.View;

/**
 * Created by Anya on 31.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        ModelFlower modelFlower = new ModelFlower();
        ModelAccessories modelAccessories = new ModelAccessories();
        Controller controller = new Controller(view, modelFlower, modelAccessories);
        controller.processFlowerCreation();
    }
}
