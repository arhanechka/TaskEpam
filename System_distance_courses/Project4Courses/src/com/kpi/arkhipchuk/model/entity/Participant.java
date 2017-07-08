package com.kpi.arkhipchuk.model.entity;

/**
 * Created by Anya on 11.06.2017.
 */
public class Participant {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private int id;

    public Participant(){
    }

    public Participant(int id, String firstName, String lastName, String login, String password, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (id != that.id) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!login.equals(that.login)) return false;
        if (!password.equals(that.password)) return false;
        return email.equals(that.email);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id;
        return result;
    }

//    @Override
//    public String toString() {
//        return "Participant{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", login='" + login + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", id=" + id +
//                '}';
//    }


    }
