package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Student;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoStudent extends GenericDao <Student>{
    Student getStudentByLogin(String login, String password);
}
