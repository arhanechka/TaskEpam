package ua.kpi.company;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Anya on 11.05.2017.
 */
public class View {
    private static ResourceBundle stringConstants = ResourceBundle.getBundle("resources/constants");
    static String INPUT_DATA = stringConstants.getString("input.data");
    static String WRONG_INPUT_INT_DATA = stringConstants.getString("wrong.input.int.data");
    static String WRONG_NUMBER = stringConstants.getString("wrong.number");
    static String WRONG_RANGE = stringConstants.getString("wrong.range");
    static String OUR_INT = stringConstants.getString("our.int");
    static String ARRAY_OUTPUT = stringConstants.getString("array.output");
    static String NUMBER_OF_ATTEMPTS = stringConstants.getString("number.of.attempts");


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFewMessages(String... messages ) {
        String [] messagesArray = messages;
        for (String s : messagesArray) {
            System.out.print(s+" ");
        }
    }

    public void printArrayOfNumbers(ArrayList<Integer> numberList) {
        for (Integer integer : numberList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        printFewMessages(NUMBER_OF_ATTEMPTS, String.valueOf(numberList.size()));
    }
}
