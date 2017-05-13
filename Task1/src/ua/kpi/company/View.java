package ua.kpi.company;


import java.util.ResourceBundle;

/**
 * Created by User on 17.03.2016.
 */
public class View {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/constants");
    static String HELLO = resourceBundle.getString("hello");
    static String WORLD = resourceBundle.getString("world");
    static String INPUT_DATA = resourceBundle.getString("input.data");
    static String WRONG_INPUT_DATA = resourceBundle.getString("wrong.input.data");
    static String OUR_SENTENCE = resourceBundle.getString("our.sentence");

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFewMessages(String... messages) {
        String[] messagesArray = messages;
        for (String s : messagesArray) {
            System.out.print(s + " ");
        }
    }

}
