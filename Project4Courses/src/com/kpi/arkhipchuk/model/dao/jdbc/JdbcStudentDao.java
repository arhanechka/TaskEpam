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
        return StudentQueryConstants.STUDENT_SELECT_BY_LOGIN_AND_PASSWORD;
    }

    protected String getInsertNewStudentQuery() {
        return StudentQueryConstants.STUDENT_INSERT_NEW_STUDENT;
    }

//    @Override
//    protected String getUpdateQuery() {
//        return "UPDATE student SET first_name = ?, last_name = ?, login = ?, password = ?, email = ? WHERE id = ?";
//    }
//
//    @Override
//    protected String getDeleteQuery() {
//        return "DELETE FROM student WHERE id = ?";
//    }
//
//    @Override
//    protected void prepareStatementForCreate(PreparedStatement statement, Student entity) throws SQLException {
//        statement.setString(1, entity.getFirstName());
//        statement.setString(2, entity.getLastName());
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Student entity) throws SQLException {
//        statement.setString(1, entity.getFirstName());
//        statement.setString(2, entity.getLastName());
//        statement.setInt(3, entity.getId());
//
//    }
//
//    @Override
//    protected void prepareStatementForDelete(PreparedStatement statement, Student entity) throws SQLException {
//        statement.setInt(1, entity.getId());
//    }

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
     * @param login
     * @param password
     * @return
     */
    @Override
    public Student getStudentByLogin(String login, String password) {
        List<Student> list;
        String sql = StudentQueryConstants.STUDENT_SELECT_BY_LOGIN_AND_PASSWORD;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, login);
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

    @Override
    public List<Student> findAll(String query, int... key) {
        List<Student> list;
        int[] keys = key;
        String sql = query;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
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
    }




