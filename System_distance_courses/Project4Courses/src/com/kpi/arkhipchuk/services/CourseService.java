package com.kpi.arkhipchuk.services;

import com.kpi.arkhipchuk.model.dao.DaoCourse;
import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.entity.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by Anya on 05.07.2017.
 */
public class CourseService {

    private static volatile CourseService instance;
    DaoFactory daoFactory;
    private static final Logger LOGGER = LogManager.getLogger(CourseService.class.getName());

    public CourseService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public static CourseService getInstance() {
        CourseService localInstance = instance;
        if (localInstance == null) {
            synchronized (CourseService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CourseService(DaoFactory.getFactory());
                }
            }
        }
        return localInstance;
    }

    public Course getCourseById(int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findCourseById(id);
    }

    public void updateCourseStatusForJoin(int currentStudentId, int courseId) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        courseDao.joinNewCourse(currentStudentId, courseId);
    }

    public void getUpdatedCourseStatusForTeacher(int currentStudentId, int courseId) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        courseDao.update(currentStudentId, courseId);
    }

    public List<Course> getListOfCurrentCoursesForStudent(int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAllCurrentCoursesForStudent(id);
    }
    public List<Course> getListOfCurrentCoursesForTeacher(int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAllCurrentCoursesForTeacher(id);
    }
    public List<Course> getListOfAccessableCoursesForStudent(int studentId, int status) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAllAccessableCoursesForStudent(studentId, status);
    }

    public List<Course> getListOfAccessableCoursesForTeacher(int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAllAccessableCoursesForTeacher(id);
    }

    public Map<String, String> findListOfFinishedCoursesAndMarks(int... id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findMap(id);
    }
}
