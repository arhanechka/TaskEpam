package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcCourseDao implements DaoCourse {
    private static final Logger LOGGER = LogManager.getLogger(JdbcCourseDao.class.getName());
    public static final String STUDENT_SELECT_FINISHED_COURSES = "SELECT c.course_name, m.mark_name FROM mark m, course c \n" +
            "JOIN stud_course_mark AS scm ON scm.course_id=c.course_id\n" +
            "WHERE NOT isnull(scm.mark_id) AND scm.mark_id=m.mark_id AND scm.st_id=?;";


    protected List<Course> parseResultSet(ResultSet rs) throws SQLException {
        List<Course> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Course course = new Course.Builder()
                        .setId(rs.getInt(CourseQueryConstants.COURSE_COLUMN_ID), false)
                        .setName(rs.getString(CourseQueryConstants.COURSE_COLUMN_NAME))
                        .setStatus(rs.getInt(CourseQueryConstants.COURSE_COLUMN_STATUS))
                        .build();
                res.add(course);
            } catch (SQLException ex) {
                LOGGER.error("SQLException in the class " + JdbcCourseDao.class.getSimpleName() + ", method parseResultSet(), was caught: " + ex);
                throw ex;
            }
        }
        return res;
    }
    @Override
    public Course findCourseById(int id) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.SELECT_COURSE)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list.get(0);

        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method find(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAll(int id) {
        return null;
    }


    @Override
    public List<Course> findAllCurrentCoursesForStudent(int id) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.STUDENT_SELECT_CURRENT_COURSES)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findAll(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAllCurrentCoursesForTeacher(int id) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.TEACHER_SELECT_CURRENT_COURSES)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findAll(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAllAccessableCoursesForStudent(int studentId, int status) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN)) {
            statement.setInt(1, studentId);
            statement.setInt(2, status);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }
            return list;
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findAll(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAllAccessableCoursesForTeacher(int id) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
            if (list == null || list.isEmpty()) {
                return null;
            }

            return list;
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findAll(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, String> findMap(int... key) {
        Map<String, String> result = new TreeMap<>();
        int[] keys = key;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(STUDENT_SELECT_FINISHED_COURSES)) {
            for (int i = 0; i < keys.length; i++) {
                statement.setInt(i + 1, keys[i]);
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    String courseName = rs.getString("course_name");
                    String mark = rs.getString("mark_name");
                    result.put(courseName, mark);
                } catch (SQLException ex) {
                    LOGGER.error("SQLException in the class " + getClass().getSimpleName() + ", method findMap(), was caught: " + ex);
                    throw ex;
                }
                if (result == null || result.isEmpty()) {
                    return null;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findMap(), was caught: " + e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public void update(int currentStudentId, int courseId) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.TEACHER_UPDATE_COURSES_FOR_ACTIVATION)) {
            statement.setInt(1, currentStudentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method update(), was caught: " + e);
        }
    }

    @Override
    public void joinNewCourse(int currentStudentId, int courseId) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CourseQueryConstants.STUDENT_UPDATE_FOR_JOIN_TO_NEW_COURSE)) {
            statement.setInt(1, currentStudentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method update(), was caught: " + e);
        }
    }
    @Override
    public void create(Course entity) {
    }

    @Override
    public void update(Course entity) {
    }

    @Override
    public void insert(Course entity) {
    }

    @Override
    public void delete(Course entity) {
    }

    @Override
    public Course find(int id) {

        return null;
    }
}




