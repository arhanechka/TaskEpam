package com.kpi.arkhipchuk.dao.jdbc;

import com.kpi.arkhipchuk.dao.DaoCourse;
import com.kpi.arkhipchuk.model.entity.Course;
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
public class JdbcCourseDao extends JdbcGenericDao<Course> implements DaoCourse {

    public static final String COURSE_COLUMN_ID = "id";
    public static final String COURSE_COLUMN_NAME = "name";
    public static final String COURSE_COLUMN_STATUS = "status";


    @Override
    protected String getSelectQuery() {
        return "SELECT course_name, t.teach_last_name, t.teach_first_name FROM course c" +
                "JOIN teacher_course as tc on tc.course_id=c.course_id" +
                "JOIN Teacher as t ON t.teach_id=tc.teacher_id" +
                "WHERE t.teach_id=?;";
    }

    protected String getSelectTeacherQuery() {
        return "SELECT course_name, t.teach_last_name, t.teach_first_name FROM course c" +
                "JOIN teacher_course as tc on tc.course_id=c.course_id" +
                "JOIN Teacher as t ON t.teach_id=tc.teacher_id" +
                "WHERE t.teach_id=?;";
    }

    protected String getSelectStudentQuery() {
        return "SELECT course_name FROM course c" +
                "JOIN stud_course_mark as scm on scm.course_id=c.course_id" +
                "JOIN student as s ON s.st_id=scm.st_id" +
                "WHERE s.st_id=1;";
    }
    @Override
    protected String getInsertQuery() {
        return "INSERT INTO course (name, status) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE course SET name = ?, status = ? WHERE id = ?";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM course WHERE id = ?";
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement statement, Course entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(2, entity.getStatus());

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Course entity) throws SQLException {
        statement.setString(1, entity.getName());
        statement.setInt(3, entity.getStatus());
        statement.setInt(4, entity.getId());
    }

    @Override
    protected void prepareStatementForDelete(PreparedStatement statement, Course entity) throws SQLException {
        statement.setInt(1, entity.getId());
    }

    @Override
    protected List<Course> parseResultSet(ResultSet rs) throws SQLException {
        List<Course> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Course course = new Course();
                course.setId(rs.getInt(COURSE_COLUMN_ID));
                course.setName(rs.getString(COURSE_COLUMN_NAME));
                course.setStatus(rs.getInt(COURSE_COLUMN_STATUS));
                res.add(course);
            } catch (SQLException ex) {
                // Logger.getLogger(JdbcCourseDao.class.getName()).log(Level.ERROR, null, ex);
                throw ex;
            }
        }
        return res;
    }

    @Override
    public void insert(Course entity) {

    }
}


