package com.kpi.arkhipchuk.model.dao;

import com.kpi.arkhipchuk.model.entity.Course;

import java.util.Map;

/**
 * Created by Anya on 07.06.2017.
 */
public interface DaoCourse extends GenericDao <Course> {
    public Map<String, String> findMap(String query, int... id);
    public void update(String query, int... id);
}
