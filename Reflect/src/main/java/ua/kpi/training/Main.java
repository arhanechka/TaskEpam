package ua.kpi.training;

import ua.kpi.training.controller.Controller;
import ua.kpi.training.model.Reflection;
import ua.kpi.training.model.entity.Data;
import ua.kpi.training.model.entity.Note;

/**
 * Created by Anya on 19.05.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Note note = new Note("Ivanov", "Ivan", "Ivanovich", "099-322-23-32", "01.01.1980");
        Reflection reflection = new Reflection(note);
        Data data = new Data();
        Reflection reflection1 = new Reflection(data);

        Controller controller = new Controller(reflection, note);
        controller.processUser();
        Controller controller1 = new Controller(reflection1, data);
        controller1.processUser();
    }
}


