package ua.kpi.training.view;

import java.util.ArrayList;

/**
 * Created by Anya on 17.05.2017.
 */
public class View {

    public void printQueue(ArrayList generalQueue) {
        int i=1;
        for (Object o : generalQueue) {
                System.out.println(i+" "+o);
        }
    }}
