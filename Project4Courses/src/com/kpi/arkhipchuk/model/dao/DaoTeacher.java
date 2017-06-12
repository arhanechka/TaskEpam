package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Teacher;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoTeacher extends GenericDao <Teacher>{
    Teacher getTeacherByLogin(String login, String password);
}
