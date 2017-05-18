package ua.kpi.training.model.entity.univerities;

import ua.kpi.training.controller.NumberConstants;
import ua.kpi.training.model.InspectionBoard;
import ua.kpi.training.model.StudentsQueue;
import ua.kpi.training.model.entity.students.Biologist;
import ua.kpi.training.view.TextConstants;

import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class BiologyUniversity extends Thread {
    ArrayList<Biologist> biologyUniversityStudents = new ArrayList<Biologist>();
    StudentsQueue studentsQueue = StudentsQueue.getInstance();
    InspectionBoard inspectionBoard = InspectionBoard.getinstance();

    public void run() {
        try {
            while (studentsQueue.ifStudentsExists()) {
                studentsQueue.addToStudentsQueue();
                biologyUniversityStudents.addAll(studentsQueue.getToBiologyUniverity());
                sleep(NumberConstants.SLEEP);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(TextConstants.NUMBER_STUDENTS_IN_UNIVERSITY + getClass().getSimpleName() + biologyUniversityStudents.size());
            System.out.println(this);
        }
    }

    public ArrayList<Biologist> getBiologyUniversityStudents() {
        return biologyUniversityStudents;
    }

    @Override
    public String toString() {
        int i = 1;
        StringBuffer sb = new StringBuffer("All students of Biology university: \n");
        for (Biologist bio : biologyUniversityStudents) {
            sb.append(i + ". " + bio.toString() + "\n");
            i++;
        }
        return sb.toString();
    }
}