package com.kpi.arkhipchuk.model.dao.jdbc;

import com.kpi.arkhipchuk.model.dao.DaoOptional;

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
    public ArrayList<Object> find(int id) {
        return null;
    }

    protected List<ArrayList<Object>> parseResultSet(ResultSet rs) throws SQLException {
        List<ArrayList<Object>> res = new ArrayList<>();
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            try {
                ArrayList<Object> temp = new ArrayList<>();
                for (int i=0; i<columns;i++){
                temp.add(rs.getObject(i+1));}
                res.add(temp);
        } catch(SQLException ex){
            //  Logger.getLogger(JdbcStudentDao.class.getName()).log(Level.ERROR, null, ex);
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
            //   logger.log(Level.ERROR, null, e);
            throw new RuntimeException(e);
        }

    }


}
