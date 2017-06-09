package com.kpi.arkhipchuk.dao;

import com.kpi.arkhipchuk.model.entity.Student;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoStudent extends GenericDao <Student>{
    Student getStudentByName(String firstName, String lastName);
}
