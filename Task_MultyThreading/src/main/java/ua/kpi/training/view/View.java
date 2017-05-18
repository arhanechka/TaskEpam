package ua.kpi.training.view;

import ua.kpi.training.model.entity.students.Student;

import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class View <T>{

    public void printQueue(ArrayList generalQueue) {
        int i=1;
        for (Object o : generalQueue) {
                System.out.println(i+" "+o);
        }
    }
public void printStudentsOfProfilesUniversity(ArrayList<T> universityStudents) {
    int i = 1;
    StringBuffer sb = new StringBuffer("All students of " + universityStudents.getClass().getSimpleName() + " university: \n");
    for (T bio : universityStudents) {
        System.out.println(i + ". " + bio.toString() + "\n");
        i++;
    }

}
}
