package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoStudent extends GenericDao <Student>{
    Student getStudentByEmail(String email, String password);
    Student getNewStudent(Student newStudent);
    public Boolean ifStudentExist(String query, String email);

}
