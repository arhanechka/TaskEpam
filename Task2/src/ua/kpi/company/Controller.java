package ua.kpi.company;

import java.util.Scanner;

/**
 * Created by Anya on 11.05.2017.
 */


public class Controller {
    Model model;
    View view;
    static int guessNumber;


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
        view.printFewMessages(View.INPUT_DATA, String.valueOf(model.getminBorderOfRange()), String.valueOf(model.getmaxBorderOfRange()));
        try {
            guessNumber = sc.nextInt();
        } catch (Exception e) {
            view.printMessage(View.WRONG_INPUT_INT_DATA);
        }
        return guessNumber;
    }

    public void game() {
        int inputetValueFromScanner = inputNumber();
        while (inputetValueFromScanner != model.getrandomWinNumber()) {
            if (!model.isTrueRange(inputetValueFromScanner)) {
                view.printMessage(View.WRONG_RANGE);
            } else {
                model.setOfRange(inputetValueFromScanner);
                model.listOfPreviousNumbers.add(inputetValueFromScanner);
            }
            view.printFewMessages(View.WRONG_NUMBER, View.ARRAY_OUTPUT);
            view.printArrayOfNumbers(model.getlistOfPreviousNumbers());
            inputetValueFromScanner = inputNumber();
        }
        model.listOfPreviousNumbers.add(inputetValueFromScanner);
        view.printFewMessages(View.OUR_INT, String.valueOf(inputetValueFromScanner));
        view.printMessage(View.ARRAY_OUTPUT);
        view.printArrayOfNumbers(model.getlistOfPreviousNumbers());

    }

}
