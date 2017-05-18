package ua.kpi.training.controller;

import ua.kpi.training.model.StudentsQueue;
import ua.kpi.training.model.entity.students.Biologist;
import ua.kpi.training.model.entity.students.Mathematician;
import ua.kpi.training.model.InspectionBoard;
import ua.kpi.training.model.entity.univerities.WideProfileUniversity;
import ua.kpi.training.model.entity.univerities.BiologyUniversity;
import ua.kpi.training.model.entity.univerities.MathUniversity;
import ua.kpi.training.view.View;

/**
 * Created by Anya on 17.05.2017.
 */
public class Controller {
    InspectionBoard inspectionBoard;
    View view;
    WideProfileUniversity allProfilesUniversity;
    MathUniversity mathUniversity;
    BiologyUniversity biologyUniversity;
    StudentsQueue studentsQueue;


    public Controller(View view, WideProfileUniversity allProfilesUniversity, MathUniversity mathUniversity, BiologyUniversity biologyUniversity) {
        inspectionBoard = InspectionBoard.getinstance();
        studentsQueue = StudentsQueue.getInstance();
        this.view = view;
        this.allProfilesUniversity = allProfilesUniversity;
        this.mathUniversity = mathUniversity;
        this.biologyUniversity = biologyUniversity;
    }

    public void processUser() throws InterruptedException {
        inspectionBoard.addStudents(new Biologist(), NumberConstants.NUMBER_BIOLOGISTS);
        inspectionBoard.addStudents(new Mathematician(), NumberConstants.NUMBER_MATHEMATICIAN);
        Thread thread1 = new Thread(biologyUniversity);
        Thread thread2 = new Thread(mathUniversity);
        Thread thread3 = new Thread(allProfilesUniversity);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
