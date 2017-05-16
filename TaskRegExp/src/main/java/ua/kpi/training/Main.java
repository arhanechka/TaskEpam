package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.DataBaseException;
import ua.kpi.training.model.entity.GlobalInformation;
import ua.kpi.training.view.View;

/**
 * Created by Anya on 14.05.2017.
 */
public class Main {

    public static void main(String[] args) throws DataBaseException {
        GlobalInformation note = new GlobalInformation();
        View view = new View();
        Controller controller = new Controller(note, view);
        controller.processUser();
    }
}
