package ua.kpi.training;

import ua.kpi.training.model.MyArrayList;

/**
 * Created by Anya on 23.05.2017.
 */
public class Main {

    public static void main(String[] args) {
    MyArrayList<Integer> list = new MyArrayList<Integer>();

    for (int i = 0; i<20; i++){
        list.add(i);
    }
        list.remove(2);
        list.set(5,23);
        list.add(234,2);

        for (Object o : list) {
            System.out.println(o);
        }
}}
