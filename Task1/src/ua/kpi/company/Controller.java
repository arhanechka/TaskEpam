package ua.kpi.company;

import java.util.Scanner;

/**
 * Created by User on 17.03.2016.
 */
public class Controller {

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

        model.setValue(inputWordsWithScanner(sc, View.HELLO));
        model.addValue(inputWordsWithScanner(sc, View.WORLD));

        view.printFewMessages(View.OUR_SENTENCE, model.getValue());
        sc.close();
    }

    // The Utility methods
    public String inputWordsWithScanner(Scanner sc, String sample) {
        view.printFewMessages(View.INPUT_DATA, sample);
        while( !sc.hasNext(sample)) {
            view.printMessage(View.WRONG_INPUT_DATA);
            view.printFewMessages(View.INPUT_DATA, sample);
            sc.next();
        }
        return sc.next();
    }
}
