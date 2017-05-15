package ua.kpi.training.view;

import ua.kpi.training.model.Model;
import ua.kpi.training.model.entity.Address;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Anya on 14.05.2017.
 */
public class View {
    public ResourceBundle resourceBundle = ResourceBundle.getBundle("consoleMessages");

    public String GREETITNG_MESSAGE = resourceBundle.getString("greeting");
    public String INPUT_INFORMATION_MESSAGE = resourceBundle.getString("input.message");
    public String WRONG_INFORMATION_MESSAGE = resourceBundle.getString("wrong.text.message");
    public String GROUP_CHECKING_MESSAGE = resourceBundle.getString("group.checking.message");
    public String IS_SECOND_MOBILE_EXIST = resourceBundle.getString("is.second.mobile.exist");
    public String BUSY_NICK_NAME = resourceBundle.getString("busy.nickname");
    public String IF_CREATE_NEW_USER = resourceBundle.getString("question.new.user");


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printFewMessages(String... messages ) {
        String [] messagesArray = messages;
        for (String s : messagesArray) {
            System.out.print(s+" ");
        }
    }

    public void printShortName (String lastName, String firstName){
        System.out.println(lastName+" "+firstName.substring(0,1)+".");
    }

    public void printFullAddress (Address address){
        System.out.println(address.toString());
    }

    public void printSingleModel (Model model){
        System.out.println(model.toString());
    }

    public void printDataBase(ArrayList<Model> noteBook) {
        for (int i=0; i<noteBook.size(); i++) {
            System.out.println("User № "+(i+1));
            System.out.println(noteBook.get(i).toString());
        }

    }

}
