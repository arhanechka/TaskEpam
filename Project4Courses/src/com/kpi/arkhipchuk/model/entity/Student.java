package com.kpi.arkhipchuk.model.entity;

/**
 * Created by Anya on 07.06.2017.
 */
public class Student extends Participant {

    public Student(){
    }

    public Student(int id, String firstName, String lastName, String login, String password, String email){
        super(id, firstName, lastName, login, password, email);
    }

}
