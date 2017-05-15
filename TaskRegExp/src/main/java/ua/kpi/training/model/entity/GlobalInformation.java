package ua.kpi.training.model.entity;

import java.time.LocalDate;

/**
 * Created by Anya on 14.05.2017.
 */
public class GlobalInformation {
    private String lastName;
    private String firstName;
    private String middleName;
    private String nickName;



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String surName) {
        this.lastName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "nickName= " + nickName+", lastName= " + lastName + ", firstName= " + firstName + ", middleName= " + middleName;
    }
}
