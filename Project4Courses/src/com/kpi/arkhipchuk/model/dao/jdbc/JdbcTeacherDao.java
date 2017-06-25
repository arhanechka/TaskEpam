package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.TeacherQueryConstants;
import com.kpi.arkhipchuk.model.entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcTeacherDao implements DaoTeacher{

    protected String getSelectQuery() {
        return TeacherQueryConstants.TEACHER_SELECT_BY_EMAIL_AND_PASSWORD;
    }
    protected String getSelectStudentsListForCurrentCourseQuery(){
        return TeacherQueryConstants.TEACHER_SELECT_STUDENT_LIST_FOR_CURRENT_COURSE;
    }
    protected String getUpdateMarkForStudentsFromCurrentCourseQuery(){
        return TeacherQueryConstants.TEACHER_UPDATE_MARK_FOR_STUDENT_FROM_CURRENT_COURSE;
    }
    protected String getSelectCourseForChangingStatus(){
        return CourseQueryConstants.TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION;
    }
    protected String getUpdateCourseStatusQuery(){
        return TeacherQueryConstants.TEACHER_UPDATE_COURSE_STATUS;
    }
    protected String getSelectListOfStudentsFromFinishedCourse(){
        return TeacherQueryConstants.TEACHER_SELECT_HISTORY_OF_STUDENTS_FROM_FINISHED_COURSE;
    }

//    protected String getUpdateQuery() {
//        return "UPDATE Teacher SET first_name = ?, last_name = ?, password = ? WHERE id = ?";
//    }
//
//    protected String getDeleteQuery() {
//        return "DELETE FROM Teacher WHERE id = ?";
//    }

//    @Override
//    protected void prepareStatementForCreate(PreparedStatement statement, Teacher entity) throws SQLException {
//        statement.setString(1, entity.getFirstName());
//        statement.setString(2, entity.getLastName());
//        statement.setString(3, entity.getPassword());
//
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Teacher entity) throws SQLException {
//        statement.setString(1, entity.getFirstName());
//        statement.setString(2, entity.getLastName());
//        statement.setString(3, entity.getPassword());
//        statement.setInt(4, entity.getId());
//    }
//
//    @Override
//    protected void prepareStatementForDelete(PreparedStatement statement, Teacher entity) throws SQLException {
//        statement.setInt(1, entity.getId());
//
//    }

    protected List<Teacher> parseResultSet(ResultSet rs) throws SQLException {
        List<Teacher> res = new ArrayList<>();
        while( rs.next() ){
            try {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt(TeacherQueryConstants.TEACHER_COLUMN_ID));
                teacher.setFirstName(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_FIRST_NAME));
                teacher.setLastName(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_LAST_NAME));
                teacher.setLogin(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_LOGIN));
                teacher.setPassword(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_PASSWORD));
                teacher.setEmail(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_EMAIL));
                res.add(teacher);
            }catch(SQLException ex) {
                //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, ex);
            }
        }
        return res;
    }


    @Override
    public void create(Teacher entity) {

    }

    @Override
    public void update(Teacher entity) {

    }

    @Override
    public void insert(Teacher entity) {
        
    }

    @Override
    public void delete(Teacher entity) {

    }

    @Override
    public Teacher find(String query,int id) {
        return null;
    }

    @Override
    public List<Teacher> findAll(String name, int... key) {
        return null;
    }


    public Teacher checkUser(String login, String password) {
        return null;
    }

    @Override
    public Teacher getTeacherByEmail(String email, String password) {
        List<Teacher> list;
        String sql = TeacherQueryConstants.TEACHER_SELECT_BY_EMAIL_AND_PASSWORD;
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
}
