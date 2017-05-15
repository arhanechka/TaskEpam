package ua.kpi.training.model.entity;

import ua.kpi.training.model.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Anya on 15.05.2017.
 */
public class DataBase {
    private static ArrayList <Model> noteBook = new ArrayList<Model>();
    private static DataBase dataBase;

    private DataBase(){}
    public static DataBase getInstance (){
        if (dataBase==null){
            dataBase= new DataBase();
        }
        return dataBase;
    }

    public boolean checkNickName(String nickName){
        for (Model model : noteBook) {
         if (nickName.equals(model.getGlobalInformation().getNickName()))
             return false;
        }
        return true;
    }

    public ArrayList<Model> getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(ArrayList<Model> noteBook) {
        this.noteBook = noteBook;
    }


    public void addNoteToNoteBook(Model model){
        noteBook.add(model);

    }



}
