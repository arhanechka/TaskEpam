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

    protected List<Course> parseResultSet(ResultSet rs) throws SQLException {
        List<Course> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Course course = new Course();
                course.setId(rs.getInt(CourseQueryConstants.COURSE_COLUMN_ID));
                course.setName(rs.getString(CourseQueryConstants.COURSE_COLUMN_NAME));
                course.setStatus(rs.getInt(CourseQueryConstants.COURSE_COLUMN_STATUS));
                res.add(course);
            } catch (SQLException ex) {
                LOGGER.error("SQLException in the class " + JdbcCourseDao.class.getSimpleName() + ", method parseResultSet(), was caught: " + ex);
                throw ex;
            }
        }
        return res;
    }

    @Override
    public void createCourseByName(String query, String courseName) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseName);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method createCourseByName(), was caught: " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void setCourseForTeacher(String query, String courseName, int teacherId) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseName);
            statement.setInt(2, teacherId);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method setCourseForTeacher(), was caught: " + e);
            throw new RuntimeException(e);
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
    public Course find(String query, int id) {
        List<Course> list;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
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
    public List<Course> findAll(String query, int... key) {
        List<Course> list;
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
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method findAll(), was caught: " + e);
            throw new RuntimeException(e);
        }
    }

    public Map<String, String> findMap(String query, int... key) {
        Map<String, String> result = new TreeMap<>();
        int[] keys = key;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
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

    public void update(String query, int... key) {
        int[] keys = key;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < keys.length; i++) {
                statement.setInt(i + 1, keys[i]);
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Exception in the class " + getClass().getSimpleName() + ", method update(), was caught: " + e);
        }
    }

}




