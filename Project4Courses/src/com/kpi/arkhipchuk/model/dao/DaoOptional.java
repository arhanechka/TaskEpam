package com.kpi.arkhipchuk.model.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 13.06.2017.
 */
public interface DaoOptional extends GenericDao <ArrayList<Object>>{
    public void updateMark (String mark, String comment, int studentId, int courseId);
}
