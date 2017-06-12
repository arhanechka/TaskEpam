package com.kpi.arkhipchuk.model.dao;

import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public interface GenericDao<T> {
    public void create (T entity);
    public void update (T entity);
    public void insert (T entity);
    public void delete (T entity);

    T find(int id);
    List<T> findAll(String query, int... key);
}
