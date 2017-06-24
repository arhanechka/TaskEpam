package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.dao.jdbc.JdbcDaoFactory;

/**
 * Created by Anya on 07.06.2017.
 */
public abstract class DaoFactory {

    public abstract DaoStudent createStudentDao();
    public abstract DaoCourse createCourseDao();
    public abstract DaoTeacher createTeacherDao();
    public abstract DaoOptional createOptionalDao();

    public static DaoFactory getFactory() {
        return JdbcDaoFactory.getFactory();
    }

}
