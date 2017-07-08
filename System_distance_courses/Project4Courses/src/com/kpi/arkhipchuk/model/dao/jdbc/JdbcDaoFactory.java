package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcDaoFactory extends DaoFactory {
    private static DataSource dataSource;
    private static JdbcDaoFactory instance;
    private static final Logger LOGGER = LogManager.getLogger(JdbcDaoFactory.class.getName());

    private JdbcDaoFactory() {
        try{
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
        }catch (Exception e) {
           LOGGER.error("Exception in "+getClass().getSimpleName()+ e);
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
            LOGGER.error("Exception in "+JdbcDaoFactory.class.getSimpleName()+ e);
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

    @Override
    public DaoOptional createOptionalDao() {
        return new JdbcOptionalDao();
    }
}
