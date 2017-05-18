package ua.kpi.training.model.entity.univerities;

import ua.kpi.training.controller.NumberConstants;
import ua.kpi.training.model.InspectionBoard;
import ua.kpi.training.model.StudentsQueue;
import ua.kpi.training.model.entity.students.Mathematician;
import ua.kpi.training.view.TextConstants;

import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class MathUniversity extends Thread {
    ArrayList<Mathematician> mathUniversityStudents = new ArrayList<Mathematician>();
    InspectionBoard inspectionBoard = InspectionBoard.getinstance();
    StudentsQueue studentsQueue = StudentsQueue.getInstance();

    public void run() {
        try {
            while (studentsQueue.ifStudentsExists()) {
                studentsQueue.addToStudentsQueue();
                mathUniversityStudents.addAll(studentsQueue.getToMathUniverity());
                sleep(NumberConstants.SLEEP);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(TextConstants.NUMBER_STUDENTS_IN_UNIVERSITY + getClass().getSimpleName() + mathUniversityStudents.size());
            System.out.println(this);
        }
    }

    public ArrayList<Mathematician> getMathUniversityStudents() {
        return mathUniversityStudents;
    }

    @Override
    public String toString() {
        int i = 1;
        StringBuffer sb = new StringBuffer("All students of math university: \n");
        for (Mathematician math : mathUniversityStudents) {
            sb.append(i + ". " + math.toString() + "\n");
            i++;
        }
        return sb.toString();
    }
}

