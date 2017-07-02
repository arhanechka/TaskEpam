package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.model.dao.*;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.*;

/**
 * Created by Anya on 07.06.2017.
 */
public class Service<T> {
    private static Service instance;
    private static DaoFactory daoFactory = DaoFactory.getFactory();
    private static final Logger LOGGER = LogManager.getLogger(Service.class.getName());

    public final String USER_EXIST_EXCEPTION = "The user data inputed is exist in the our database!";

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public Student checkStudent(String email, String password) {
        DaoStudent studentDao = daoFactory.createStudentDao();
        Student student = studentDao.getStudentByEmail(email, password);
        return student;
    }

    public Teacher checkTeacher(String email, String password) {
        DaoTeacher teacherDao = daoFactory.createTeacherDao();
        Teacher teacher = teacherDao.getTeacherByEmail(email, password);
        return teacher;
    }

    public Student checkAndRegUser(String firstName, String lastName, String login, String password, String email) throws UserIsAlreadyExistException {
        DaoStudent studentDao = daoFactory.createStudentDao();
//        try {
//            studentDao.getStudentByEmail(email, password);
//            return studentDao.getNewStudent(firstName, lastName, login, password, email);
//        } catch (UserIsAlreadyExistException e) {
//            LOGGER.error("User " + lastName + " was found in database");
//            return null;
//        }
        if (!studentDao.ifStudentExist(StudentQueryConstants.STUDENT_SELECT_BY_EMAIL, email)) {
            LOGGER.error(USER_EXIST_EXCEPTION);
            throw new UserIsAlreadyExistException();
        }
        return studentDao.getNewStudent(firstName, lastName, login, password, email);
    }

    public void createNewCourse(String query, String courseName) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        courseDao.createCourseByName(query, courseName);
    }

    public void setCourseToTeacher(String query, String courseName, int teacherId) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        courseDao.setCourseForTeacher(query, courseName, teacherId);
    }

    public Course getCourseByStudentId(String query, int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.find(query, id);
    }

    public Course getCourseById(String query, int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.find(query, id);
    }

    public void updateCourseStatus(String query, int... key) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        courseDao.update(query, key);
    }

    public List<Course> findListOfCourses(String query, int... keys) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAll(query, keys);
    }

    public List<ArrayList<Object>> findListOfSpecificStrings(String query, int... id) {
        DaoOptional daoOptional = daoFactory.createOptionalDao();
        return daoOptional.findAll(query, id);
    }

    public void setStudentMark(String mark, String comment, int studentId, int courseId) {
        DaoOptional daoOptional = daoFactory.createOptionalDao();
        daoOptional.updateMark(mark, comment, studentId, courseId);
    }


    public Map<String, String> findListOfTwoStrings(String query, int... id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findMap(query, id);
    }

    public List<Student> findListOfStudentForCourses(String query, int id) {
        DaoStudent studentDao = daoFactory.createStudentDao();
        return studentDao.findAll(query, id);

    }

    public void startNewCourse(String query, int... key) {
        DaoCourse courseDao = daoFactory.createCourseDao();
    }
}
