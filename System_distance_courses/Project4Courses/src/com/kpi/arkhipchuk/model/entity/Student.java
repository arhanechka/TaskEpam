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
    public static class Builder{
        Student instance = new Student();

        public Builder setId(int id, boolean isNull) {
            if(!isNull) {
                instance.setId(id);
            }else{
                instance.setId(0);
            }
            return this;
        }

        public Builder setLastName(String lastName) {
            instance.setLastName(lastName);
            return this;
        }

        public Builder setFirstName(String firstName) {
            instance.setFirstName(firstName);
            return this;
        }

        public Builder setLogin(String login) {
            instance.setLogin(login);
            return this;
        }

        public Builder setPassword(String password) {
            instance.setPassword(password);
            return this;
        }

        public Builder setEmail(String email) {
            instance.setEmail(email);
            return this;
        }

        public Student build() {
            return instance;
        }
    }

}
