package com.kpi.arkhipchuk.model.entity;

/**
 * Created by Anya on 07.06.2017.
 */
public class Teacher extends Participant{
    public Teacher(){
    super();
    }

    public Teacher(int id, String firstName, String lastName, String login, String password, String email){
        super(id, firstName, lastName, login, password, email);
    }
}
