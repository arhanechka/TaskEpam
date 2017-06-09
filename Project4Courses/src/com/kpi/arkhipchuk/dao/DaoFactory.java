package com.kpi.arkhipchuk.dao;

import com.kpi.arkhipchuk.dao.jdbc.JdbcDaoFactory;
import com.kpi.arkhipchuk.model.entity.Student;

/**
 * Created by Anya on 07.06.2017.
 */
public abstract class DaoFactory {

    public abstract DaoStudent createStudentDao();
    public abstract DaoCourse createCourseDao();
    public abstract DaoTeacher createTeacherDao();

    public static DaoFactory getFactory() {
        return JdbcDaoFactory.getFactory();
    }

}
