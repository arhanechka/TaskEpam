package com.kpi.arkhipchuk.services;

import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.entity.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Anya on 05.07.2017.
 */
public class TeacherService {
    private static volatile TeacherService instance;
    DaoFactory daoFactory ;
    private static final Logger LOGGER = LogManager.getLogger(TeacherService.class.getName());

   public TeacherService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public static TeacherService getInstance() {
        TeacherService localInstance = instance;
        if (localInstance == null) {
            synchronized (TeacherService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TeacherService(DaoFactory.getFactory());
                }
            }
        }
        return localInstance;
    }

    public Teacher checkTeacher(String email, String password) {
        DaoTeacher teacherDao = daoFactory.createTeacherDao();
        Teacher teacher = teacherDao.getTeacherByEmail(email, password);
        return teacher;
    }

}
