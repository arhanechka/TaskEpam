package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.kpi.arkhipchuk.model.dao.DaoTeacher;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcDaoFactory extends DaoFactory {
    private static DataSource dataSource;
    private static JdbcDaoFactory instance;
    private JdbcDaoFactory() {
        try{
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
        }catch (Exception e) {
           // logger.log(Level.ERROR, null, e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized JdbcDaoFactory getFactory() {
        if(instance == null) {
            instance = new JdbcDaoFactory();
        }
        return instance;
    }

    public static Connection getConnection() {
        try{
            return dataSource.getConnection();
        }catch (Exception e) {
           // logger.log(Level.ERROR, null, e);
            throw new RuntimeException(e);
        }
    }
    @Override
    public DaoStudent createStudentDao() {
        return new JdbcStudentDao();
    }

    @Override
    public DaoCourse createCourseDao() {
        return new JdbcCourseDao();
    }

    @Override
    public DaoTeacher createTeacherDao() {
        return new JdbcTeacherDao();
    }
}
