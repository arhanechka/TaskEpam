package ua.kpi.company;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {
       ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/constants");

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setValue(inputWordsWithScanner(sc, resourceBundle.getString("HELLO")));
        model.addValue(inputWordsWithScanner(sc, resourceBundle.getString("WORLD")));

        view.printTwoMessages(resourceBundle.getString("OUR_SENTENCE"), model.getValue());
    }

    // The Utility methods
    public String inputWordsWithScanner(Scanner sc, String sample) {
        view.printTwoMessages(resourceBundle.getString("INPUT_DATA"), sample);
        while( !sc.hasNext(sample)) {
            view.printMessage(resourceBundle.getString("WRONG_INPUT_DATA"));
            view.printTwoMessages(resourceBundle.getString("INPUT_DATA"), sample);
            sc.next();
        }
        return sc.next();
    }
}
