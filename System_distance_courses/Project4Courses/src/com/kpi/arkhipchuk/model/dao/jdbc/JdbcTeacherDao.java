package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.TeacherQueryConstants;
import com.kpi.arkhipchuk.model.entity.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class JdbcTeacherDao implements DaoTeacher {
    private static final Logger LOGGER = LogManager.getLogger(JdbcOptionalDao.class.getName());


    protected List<Teacher> parseResultSet(ResultSet rs) throws SQLException {
        List<Teacher> res = new ArrayList<>();
        while (rs.next()) {
            try {
                Teacher teacher = new Teacher.Builder()
                        .setId(rs.getInt(TeacherQueryConstants.TEACHER_COLUMN_ID), false)
                        .setFirstName(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_FIRST_NAME))
                        .setLastName(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_LAST_NAME))
                        .setLogin(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_LOGIN))
                        .setPassword(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_PASSWORD))
                        .setEmail(rs.getString(TeacherQueryConstants.TEACHER_COLUMN_EMAIL))
                        .build();
                res.add(teacher);
            } catch (SQLException ex) {
                LOGGER.error("SQLException in " + getClass().getSimpleName() + ex);
            }
        }
        return res;
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
            LOGGER.error("SQLException in " + getClass().getSimpleName() + e);
            return null;
        }
    }

    @Override
    public void create(Teacher entity) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(TeacherQueryConstants.TEACHER_CREATE, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                entity.setId(keys.getInt(1));
            }
        } catch (Exception e) {
            LOGGER.error("Exception in " + getClass().getSimpleName() + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Teacher entity) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(TeacherQueryConstants.TEACHER_UPDATE)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Exception in " + getClass().getSimpleName() + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Teacher entity) {
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(TeacherQueryConstants.TEACHER_DELETE)) {
            statement.setInt(1, entity.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Exception in " + getClass().getSimpleName() + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher find(int id) {
        return null;
    }

    @Override
    public List<Teacher> findAll(int id) {
        return null;
    }


}
