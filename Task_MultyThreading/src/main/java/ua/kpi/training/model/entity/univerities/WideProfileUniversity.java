package ua.kpi.training.model.entity.univerities;

import ua.kpi.training.controller.NumberConstants;
import ua.kpi.training.model.InspectionBoard;
import ua.kpi.training.model.StudentsQueue;
import ua.kpi.training.model.entity.students.Biologist;
import ua.kpi.training.model.entity.students.Mathematician;
import ua.kpi.training.model.entity.students.Student;
import ua.kpi.training.view.TextConstants;

import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class WideProfileUniversity extends Thread {
    int randomNumber;
    InspectionBoard inspectionBoard = InspectionBoard.getinstance();
    StudentsQueue studentsQueue = StudentsQueue.getInstance();

    ArrayList<Student> allProfilesUniversityStudents = new ArrayList<Student>();

    public void run() {
        try {
            while (studentsQueue.ifStudentsExists()) {
                studentsQueue.addToStudentsQueue();
                randomNumber = (int) (Math.random() * 5 + 1);
                allProfilesUniversityStudents.addAll(studentsQueue.getToWideProfileUniverity(randomNumber));
                sleep(NumberConstants.SLEEEP);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(TextConstants.NUMBER_STUDENTS_IN_UNIVERSITY + getClass().getSimpleName() + allProfilesUniversityStudents.size());
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("All students from the university of wide profile:\n");
        int i = 1;
        for (Student allProfilesUniversityStudent : allProfilesUniversityStudents) {
            sb.append(i + ". ");
            if (allProfilesUniversityStudent instanceof Biologist) {
                sb.append("Biologist\n");
            } else if (allProfilesUniversityStudent instanceof Mathematician) {
                sb.append("Mathematician\n");
            }
            i++;
        }
        return sb.toString();
    }

    public ArrayList<Student> getAllProfilesUniversityStudents() {
        return allProfilesUniversityStudents;
    }
}

