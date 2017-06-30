package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Student;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoStudent extends GenericDao <Student>{
    Student getStudentByEmail(String email, String password);
    Student getNewStudent(String firstName, String lastName, String login, String password, String email);
    public Boolean ifStudentExist(String query, String email);

}
