package ua.kpi.training.controller;

import ua.kpi.training.controller.services.UserInputData;
import ua.kpi.training.model.DataBaseException;
import ua.kpi.training.model.entity.DataBase;
import ua.kpi.training.model.entity.GlobalInformation;
import ua.kpi.training.view.View;
import java.util.Scanner;

/**
 * Created by Anya on 14.05.2017.
 */
public class Controller {
    UserInputData userInputData;
    View view;
    DataBase dataBase;
    Scanner sc;

    public Controller(GlobalInformation note, View view) {
        userInputData = new UserInputData(new Scanner(System.in), view);
        this.view = view;
        dataBase = DataBase.getInstance();
        sc = new Scanner(System.in);
    }

    public void processUser() throws DataBaseException {
        view.printMessage(view.IF_CREATE_NEW_USER);
        while (!sc.next().equals("N")) {
            userInputData.createNote();
            dataBase.addNoteToNoteBook(userInputData.model);
            view.printMessage(view.IF_CREATE_NEW_USER);
        }
        view.printDataBase(dataBase.getNoteBook());
sc.close();
    }
}

