package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.model.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcStudentDao implements DaoStudent {
    private static final Logger LOGGER = LogManager.getLogger(JdbcOptionalDao.class.getName());

    protected List<Student> parseResultSet(ResultSet rs) throws SQLException {
        List<Student> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Student student = new Student.Builder()
                        .setId(rs.getInt(StudentQueryConstants.STUDENT_COLUMN_ID), false)
                        .setFirstName(rs.getString(StudentQueryConstants.STUDENT_COLUMN_FIRST_NAME))
                        .setLastName(rs.getString(StudentQueryConstants.STUDENT_COLUMN_LAST_NAME))
                        .setLogin(rs.getString(StudentQueryConstants.STUDENT_COLUMN_LOGIN))
                        .setPassword(rs.getString(StudentQueryConstants.STUDENT_COLUMN_PASSWORD))
                        .setEmail(rs.getString(StudentQueryConstants.STUDENT_COLUMN_EMAIL))
                        .build();
                res.add(student);
            } catch (SQLException ex) {
                LOGGER.error("SQLException in " + getClass().getSimpleName() + ex);
            }
        }
        return res;
    }

    @Override
    public Student getStudentByEmail(String email, String password) {
        List<Student> list;
        String sql = StudentQueryConstants.STUDENT_SELECT_BY_EMAIL_AND_PASSWORD;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list.get(0);
        } catch (SQLException e) {
            LOGGER.error("SQLException in " + getClass().getSimpleName() + e);
            return null;
        }
    }

    @Override
    public Student getNewStudent(String firstName, String lastName, String login, String password, String email) {
        String sqlInsert = StudentQueryConstants.STUDENT_INSERT_NEW_STUDENT;
        List<Student> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlInsert)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setString(5, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in " + getClass().getSimpleName() + e);
        }
        return getStudentByEmail(email, password);
    }

    @Override
    public List<Student> findAll(int id) {
        List<Student> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            LOGGER.error("Exception in " + getClass().getSimpleName() + e);
            throw new RuntimeException(e);
        }
    }

    public Boolean ifStudentExist(String query, String email) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs != null)
                return true;
        } catch (Exception e) {
            LOGGER.error("Exception in " + getClass().getSimpleName() + e);
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void create(Student entity) {

    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void insert(Student entity) {

    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public Student find(int id) {
        return null;
    }
}




