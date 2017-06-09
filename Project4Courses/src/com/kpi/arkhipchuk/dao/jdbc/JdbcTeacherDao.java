package com.kpi.arkhipchuk.dao.jdbc;

import com.kpi.arkhipchuk.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.entity.Teacher;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcTeacherDao extends JdbcGenericDao <Teacher> implements DaoTeacher{


    public static final String TEACHER_COLUMN_ID = "teach_id";
    public static final String TEACHER_COLUMN_FIRST_NAME = "teach_first_name";
    public static final String TEACHER_COLUMN_LAST_NAME = "teach_last_name";
    public static final String TEACHER_COLUMN_LOGIN = "teach_login";
    public static final String TEACHER_COLUMN_PASSWORD = "teach_pasword";
    public static final String TEACHER_COLUMN_EMAIL = "teach_email";

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM teacher WHERE  teach_login = ? AND teach_pasword = ?";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Teacher (first_name, last_name, password) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Teacher SET first_name = ?, last_name = ?, password = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Teacher WHERE id = ?";
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement statement, Teacher entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getPassword());

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Teacher entity) throws SQLException {
        statement.setString(1, entity.getFirstName());
        statement.setString(2, entity.getLastName());
        statement.setString(3, entity.getPassword());
        statement.setInt(4, entity.getId());
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Teacher entity) throws SQLException {
        statement.setInt(1, entity.getId());

    }

    @Override
    protected List<Teacher> parseResultSet(ResultSet rs) throws SQLException {
        List<Teacher> res = new ArrayList<>();
        while( rs.next() ){
            try {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt(TEACHER_COLUMN_ID));
                teacher.setFirstName(rs.getString(TEACHER_COLUMN_FIRST_NAME));
                teacher.setLastName(rs.getString(TEACHER_COLUMN_LAST_NAME));
                teacher.setLogin(rs.getString(TEACHER_COLUMN_LOGIN));
                teacher.setPassword(rs.getString(TEACHER_COLUMN_PASSWORD));
                teacher.setEmail(rs.getString(TEACHER_COLUMN_EMAIL));
                res.add(teacher);
            }catch(SQLException ex) {
                //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return res;
    }


    @Override
    public void insert(Teacher entity) {
        
    }

    @Override
    public Teacher getTeacherByName(String firstName, String lastName) {
        return null;
    }
}
