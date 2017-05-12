package ua.kpi.company;

import java.util.Scanner;
import java.util.ResourceBundle;

/**
 * Created by Anya on 11.05.2017.
 */


public class Controller {
    Model model;
    View view;
    static int number;
    private ResourceBundle stringConstants = ResourceBundle.getBundle("resources/constants");


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        model.setRandomValue();
        game();
    }

    public int inputNumber() {
        Scanner sc = new Scanner(System.in);
        view.printMessage(stringConstants.getString("INPUT_DATA") + " "+ model.getMin() + " and " + model.getMax());
        try {
            number = sc.nextInt();
        } catch (Exception e) {
            view.printMessage(stringConstants.getString("WRONG_INPUT_INT_DATA"));
        }
        return number;
    }

    private void setOfRange(int number) {
        if (number < model.getNumberForGuess()) {
            model.setMin(number);
        } else if (number > model.getNumberForGuess()) {
            model.setMax(number);
        }
    }

    private boolean isTrueRange (int number){
        if (number<model.getMin() || number >model.getMax()) {
            return false;
        }
        return true;
    }

    public void game() {
        int temp = inputNumber();
        while (temp != model.getNumberForGuess()) {
            if (!isTrueRange(temp)) {
                view.printMessage(stringConstants.getString("WRONG_RANGE"));
            } else {
                setOfRange(temp);
                model.numbersList.add(temp);}
                view.printMessageAndInt(stringConstants.getString("WRONG_NUMBER"), stringConstants.getString("ARRAY_OUTPUT"));
                view.printArrayOfNumbers(model.getNumbersList());
                temp = inputNumber();
           }
            model.numbersList.add(temp);
            view.printMessageAndInt(stringConstants.getString("OUR_INT"), String.valueOf(temp));
            view.printMessage(stringConstants.getString("ARRAY_OUTPUT"));
            view.printArrayOfNumbers(model.getNumbersList());

    }

}
