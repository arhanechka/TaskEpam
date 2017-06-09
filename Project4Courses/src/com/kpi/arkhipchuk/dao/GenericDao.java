package com.kpi.arkhipchuk.dao;

import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public interface GenericDao<T> {
    public void create (T entity);
    public void update (T entity);
    public void insert (T entity);
    public void delete (T entity);

    T find(String login, String password);
    List<T> findAll();
}
