package ua.kpi.training.model;


import ua.kpi.training.model.entity.students.Biologist;
import ua.kpi.training.model.entity.students.Mathematician;
import ua.kpi.training.model.entity.students.Student;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Anya on 17.05.2017.
 */
public class InspectionBoard {
    private static InspectionBoard instance;
    private volatile ArrayList<Student> generalQueue;

    private InspectionBoard() {
    }

    public static InspectionBoard getinstance() {
        if (instance == null) {
            instance = new InspectionBoard();
        }
        instance.setGeneralQueue();
        return instance;
    }

    public void setGeneralQueue() {
        if (generalQueue == null) {
            generalQueue = new ArrayList<Student>();
        }
    }

    public void addStudents(Student student, int countOsStudents) {
        for (int i = 0; i < countOsStudents; i++) {
            if (student instanceof Biologist) {
                generalQueue.add(new Biologist());
            }
            else {
                generalQueue.add(new Mathematician());
            }
        }
        Collections.shuffle(generalQueue);
    }

    public synchronized ArrayList<Student> movingToStudentsQueue(int count) {
        ArrayList<Student> generalQueueForMoving = new ArrayList<Student>();
        if (count <= generalQueue.size()) {
            for (int i = 0; i < count; i++) {
                generalQueueForMoving.add(generalQueue.get(0));
                generalQueue.remove(0);
            }
        } else {
            generalQueueForMoving.addAll(generalQueue);
            generalQueue.removeAll(generalQueue);
        }
        return generalQueueForMoving;
    }

    public ArrayList<Student> getGeneralQueue() {
        return generalQueue;
    }

}


