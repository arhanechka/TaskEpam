package ua.kpi.company;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Anya on 11.05.2017.
 */
public class View {
    private ResourceBundle stringConstants = ResourceBundle.getBundle("resources/constants");


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, String value){
        System.out.println(message + " "+value);
    }

    public void printArrayOfNumbers(ArrayList<Integer> numberList){
        for (Integer integer : numberList) {
            System.out.print(integer+" ");
        }
        System.out.println();
        printMessageAndInt(stringConstants.getString("ATTEMPTS_NUMBER"), String.valueOf(numberList.size()));
    }
}
