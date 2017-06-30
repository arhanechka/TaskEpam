package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.model.entity.Student;

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

    protected String getSelectQuery() {
        return StudentQueryConstants.STUDENT_SELECT_BY_EMAIL_AND_PASSWORD;
    }

    protected String getInsertNewStudentQuery() {
        return StudentQueryConstants.STUDENT_INSERT_NEW_STUDENT;
    }

    protected List<Student> parseResultSet(ResultSet rs) throws SQLException {
        List<Student> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Student student = new Student();
                student.setId(rs.getInt(StudentQueryConstants.STUDENT_COLUMN_ID));
                student.setFirstName(rs.getString(StudentQueryConstants.STUDENT_COLUMN_FIRST_NAME));
                student.setLastName(rs.getString(StudentQueryConstants.STUDENT_COLUMN_LAST_NAME));
                student.setLogin(rs.getString(StudentQueryConstants.STUDENT_COLUMN_LOGIN));
                student.setPassword(rs.getString(StudentQueryConstants.STUDENT_COLUMN_PASSWORD));
                student.setEmail(rs.getString(StudentQueryConstants.STUDENT_COLUMN_EMAIL));
                res.add(student);
            } catch (SQLException ex) {
                //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return res;
    }

    /**
     * Retrun first Student object with equal first name and last name
     *
     * @param email
     * @param password
     * @return
     */
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
            //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, e);
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
            e.printStackTrace();
        }return getStudentByEmail(email,password);
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
    public Student find(String query,int id) {
        return null;
    }

    @Override
    public List<Student> findAll(String query, int... key) {
        List<Student> list;
        int[] keys = key;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < keys.length; i++) {
                statement.setInt(i + 1, keys[i]);
            }
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            //   logger.log(Level.ERROR, null, e);
            throw new RuntimeException(e);
        }
    }
    public Boolean ifStudentExist(String query, String email){
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            if (rs!=null)
            return true;
        } catch (Exception e) {
            //   logger.log(Level.ERROR, null, e);
            throw new RuntimeException(e);
        }
    return false;}
    }




