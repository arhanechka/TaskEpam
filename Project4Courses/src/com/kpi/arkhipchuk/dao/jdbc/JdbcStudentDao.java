package com.kpi.arkhipchuk.dao.jdbc;

import com.kpi.arkhipchuk.dao.DaoStudent;
import com.kpi.arkhipchuk.model.entity.Student;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcStudentDao extends JdbcGenericDao <Student> implements DaoStudent{
    public static final String STUDENT_COLUMN_ID = "st_id";
    public static final String STUDENT_COLUMN_FIRST_NAME = "st_first_name";
    public static final String STUDENT_COLUMN_LAST_NAME = "st_last_name";
    public static final String STUDENT_COLUMN_LOGIN = "st_login";
    public static final String STUDENT_COLUMN_PASSWORD = "st_password";
    public static final String STUDENT_COLUMN_EMAIL = "st_email";




    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM student WHERE st_login = ? AND st_password = ?";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO student (first_name, last_name, login, password, email) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE student SET first_name = ?, last_name = ?, login = ?, password = ?, email = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM student WHERE id = ?";
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement statement, Student entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Student entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setInt(3, entity.getId());

    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Student entity) throws SQLException {
        statement.setInt(1, entity.getId());
    }

    @Override
    protected List<Student> parseResultSet(ResultSet rs) throws SQLException {
        List<Student> res = new ArrayList<>();
        while( rs.next() ){
            try {
                Student student = new Student();
                student.setId(rs.getInt(STUDENT_COLUMN_ID));
                student.setFirstName(rs.getString(STUDENT_COLUMN_FIRST_NAME));
                student.setLastName(rs.getString(STUDENT_COLUMN_LAST_NAME));
                student.setLogin(rs.getString(STUDENT_COLUMN_LOGIN));
                student.setPassword(rs.getString(STUDENT_COLUMN_PASSWORD));
                student.setEmail(rs.getString(STUDENT_COLUMN_EMAIL));
                res.add(student);
            }catch(SQLException ex) {
              //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return res;
    }

    /**
     * Retrun first Student object with equal first name and last name
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public Student getStudentByName(String firstName, String lastName) {
        List<Student> list;
        String sql = "SELECT * FROM student WHERE first_name = ? AND last_name = ?";
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
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
    public void insert(Student entity) {

    }
}

