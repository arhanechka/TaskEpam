package ua.kpi.training.model.entity;

import ua.kpi.training.model.NoteAnnotations;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Anya on 19.05.2017.
 */
public class Note extends Data implements TestInterface{
    private static String lastname;
    private String firstname;
    private String middlename;
    private String phone;
    private String birthday;
    private final Date currentDate;

    public Note() {
        currentDate = new Date();
    }

    public Note(String lastname, String firstname, String middlename, String phone, String birthday) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.phone = phone;
        this.birthday = birthday;
        currentDate = new Date();

    }

    @NoteAnnotations
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @NoteAnnotations
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @NoteAnnotations

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @NoteAnnotations
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NoteAnnotations
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @NoteAnnotations
    public int getDifferenceBetweenDates(String birthday){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        try {
            date1 = format.parse(birthday);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long difference = date1.getTime() - currentDate.getTime();
        return (int)(difference / (24 * 60 * 60 * 1000)+1);
    }

    @Override
    @NoteAnnotations
    public String toString() {
        return "Note{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
