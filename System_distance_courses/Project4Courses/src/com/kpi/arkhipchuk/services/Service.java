package com.kpi.arkhipchuk.services;

import com.kpi.arkhipchuk.model.dao.*;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Class Singleton for initialization of Dao and calling their methods
 */
public class Service {
    private static volatile Service instance;
    DaoFactory daoFactory ;
    private static final Logger LOGGER = LogManager.getLogger(Service.class.getName());


    public Service(DaoFactory daoFactory) {
         this.daoFactory = daoFactory;
    }
    public static Service getInstance() {
        Service localInstance = instance;
        if (localInstance == null) {
            synchronized (Service.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Service(DaoFactory.getFactory());
                }
            }
        }
        return localInstance;
    }

    public List<ArrayList<Object>> findListOfSpecificStrings(int id) {
        DaoOptional daoOptional = daoFactory.createOptionalDao();
        return daoOptional.findAll(id);
    }

    public void setStudentMark(String mark, String comment, int studentId, int courseId) {
        DaoOptional daoOptional = daoFactory.createOptionalDao();
        daoOptional.updateMark(mark, comment, studentId, courseId);
    }
}
