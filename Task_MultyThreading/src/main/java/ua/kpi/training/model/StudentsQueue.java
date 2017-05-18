package ua.kpi.training.model;

import ua.kpi.training.controller.NumberConstants;
import ua.kpi.training.model.entity.students.Biologist;
import ua.kpi.training.model.entity.students.Mathematician;
import ua.kpi.training.model.entity.students.Student;
import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class StudentsQueue {
    private volatile ArrayList<Student> waitingQueue;
    private static StudentsQueue instance;
    InspectionBoard inspectionBoard = InspectionBoard.getinstance();

    private StudentsQueue() {
    }

    public static StudentsQueue getInstance() {
        if (instance == null) {
            instance = new StudentsQueue();
        }
        instance.setWaitingQueue();
        return instance;
    }

    public void setWaitingQueue() {
        if (waitingQueue == null) {
            waitingQueue = new ArrayList<Student>();
        }
    }

    public ArrayList<Student> getWaitingQueue() {
        return waitingQueue;
    }

    public synchronized void addToStudentsQueue() {
        if (waitingQueue.size() < NumberConstants.LOW_QUEUE_BOARD) {
            int temp = NumberConstants.UPPER_QUEUE_BOARD - waitingQueue.size();
            waitingQueue.addAll(inspectionBoard.movingToStudentsQueue(temp));
        }
    }

    public int checkSizeOfStudentsQueue(int countForMovie) {
        if (countForMovie <= waitingQueue.size()) {
            return countForMovie;
        } else {
            return waitingQueue.size();
        }
    }

    public boolean ifStudentsExists() {
        if (inspectionBoard.getGeneralQueue().size() > 0 || getWaitingQueue().size() > 0) {
            return true;
        }
        return false;
    }

    public synchronized ArrayList<Biologist> getToBiologyUniverity() {
        ArrayList<Biologist> listForMoving = new ArrayList<Biologist>();
        if (ifStudentsExists() && getWaitingQueue().get(0) instanceof Biologist) {
            listForMoving.add((Biologist) getWaitingQueue().get(0));
            waitingQueue.remove(0);
        }
        return listForMoving;
    }

    public synchronized ArrayList<Mathematician> getToMathUniverity() {
        ArrayList<Mathematician> listForMoving = new ArrayList<Mathematician>();
        if (ifStudentsExists() && getWaitingQueue().get(0) instanceof Mathematician) {
            listForMoving.add((Mathematician) getWaitingQueue().get(0));
            waitingQueue.remove(0);
        }
        return listForMoving;
    }

    public synchronized ArrayList<Student> getToWideProfileUniverity(int count) {

        ArrayList<Student> listForMoving = new ArrayList<Student>();
        for (int i = 0; i < checkSizeOfStudentsQueue(count); i++) {
            listForMoving.add(getWaitingQueue().get(0));
            waitingQueue.remove(0);
        }
        return listForMoving;

    }

}
