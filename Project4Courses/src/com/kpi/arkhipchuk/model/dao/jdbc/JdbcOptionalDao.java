package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoOptional;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 13.06.2017.
 */
public class JdbcOptionalDao implements DaoOptional {
    private static final Logger LOGGER = LogManager.getLogger(JdbcOptionalDao.class.getName());

    @Override
    public void create(ArrayList<Object> entity) {

    }

    @Override
    public void update(ArrayList<Object> entity) {

    }

    @Override
    public void insert(ArrayList<Object> entity) {

    }

    @Override
    public void delete(ArrayList<Object> entity) {

    }

    @Override
    public ArrayList<Object> find(String query, int id) {
        return null;
    }

    protected List<ArrayList<Object>> parseResultSet(ResultSet rs) throws SQLException {
        List<ArrayList<Object>> res = new ArrayList<>();
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            try {
                ArrayList<Object> temp = new ArrayList<>();
                for (int i = 0; i < columns; i++) {
                    temp.add(rs.getObject(i + 1));
                }
                res.add(temp);
            } catch (SQLException ex) {
                LOGGER.error("SQLException in "+getClass().getSimpleName()+ ex);
            }
        }
        return res;
    }

    @Override
    public List<ArrayList<Object>> findAll(String query, int... key) {
        List<ArrayList<Object>> list;
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
            LOGGER.error("Exception in "+getClass().getSimpleName()+ e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateMark(String mark, String comment, int studentId, int courseId) {
        String sql = StudentQueryConstants.STUDENT_UPDATE_MARK_AND_COMMENT;
        try (Connection connection = JdbcDaoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mark);
            statement.setString(2, comment);
            statement.setInt(3, studentId);
            statement.setInt(4, courseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("SQLException in "+getClass().getSimpleName()+ e);
        }


    }
}
