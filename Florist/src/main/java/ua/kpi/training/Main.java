package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.Model;
import ua.kpi.training.model.entity.flowers.CatalogFlowers;
import ua.kpi.training.view.View;

import java.util.AbstractList;

/**
 * Created by Anya on 31.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        controller.processFlowerCreation();
    }
}
