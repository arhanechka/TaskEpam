package ua.kpi.training.model;

import ua.kpi.training.controller.MyException;
import ua.kpi.training.view.TextConstants;

import java.util.ArrayList;

/**
 * Created by Anya on 23.05.2017.
 */
public class MyArrayList <E> extends ArrayList <E>{

    @Override
    public Object set(int index, Object element) {
        try {
            throw new MyException(TextConstants.SET);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public void add(int index, Object element) {
        try {
            throw new MyException(TextConstants.ADD);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public E remove(int index) {
        try {
            throw new MyException(TextConstants.REMOVE);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

}
