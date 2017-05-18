package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.StudentsQueue;
import ua.kpi.training.model.entity.univerities.WideProfileUniversity;
import ua.kpi.training.model.entity.univerities.BiologyUniversity;
import ua.kpi.training.model.entity.univerities.MathUniversity;
import ua.kpi.training.view.View;

/**
 * Created by Anya on 17.05.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WideProfileUniversity allProfilesUniversity = new WideProfileUniversity();
        StudentsQueue studentsQueue = StudentsQueue.getInstance();
        MathUniversity mathUniversity = new MathUniversity();
        BiologyUniversity biologyUniversity = new BiologyUniversity();
        View view = new View();
        Controller controller = new Controller(view, allProfilesUniversity, mathUniversity, biologyUniversity);
        controller.processUser();
    }
}
