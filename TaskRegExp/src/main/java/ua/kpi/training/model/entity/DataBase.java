package ua.kpi.training.model.entity;

import ua.kpi.training.model.DataBaseException;
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

    public void checkNickName(String nickName, String error) throws DataBaseException {
        for (Model model : noteBook) {
         if (nickName.equals(model.getGlobalInformation().getNickName()))
             throw new DataBaseException(error);
        }

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
