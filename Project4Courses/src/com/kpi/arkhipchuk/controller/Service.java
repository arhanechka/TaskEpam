package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.model.dao.*;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Mark;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;

import java.util.*;

/**
 * Created by Anya on 07.06.2017.
 */
public class Service<T> {
    private static Service instance;
    private static DaoFactory daoFactory = DaoFactory.getFactory();

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public Student checkStudent(String login, String password) {
        DaoStudent studentDao = daoFactory.createStudentDao();
        Student student = studentDao.getStudentByLogin(login, password);
        return student;
    }

    public Teacher checkTeacher(String login, String password) {
        DaoTeacher teacherDao = daoFactory.createTeacherDao();
        Teacher teacher = teacherDao.getTeacherByLogin(login, password);
        return teacher;
    }

    public Boolean checkAndRegUser(String firstName, String lastName, String login, String password, String email) {
        return true;
    }
//    public Teacher getTeacherById(int id) {
//        DaoTeacher teacherDao = daoFactory.createTeacherDao();
//        return teacherDao.find(id);
//    }
//
//    public Student getStudentById(int id) {
//        DaoStudent studentDao = daoFactory.createStudentDao();
//        return studentDao.find(id);
//    }

    public Course getCourseByStudentId(int id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.find(id);
    }

    public List<Course> findListOfCourses(String query, int... keys) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findAll(query, keys);
    }

    public Map<String, String> findListOfTwoStrings(String query, int... id) {
        DaoCourse courseDao = daoFactory.createCourseDao();
        return courseDao.findMap(query, id);
    }

    public Map<Course, List<Student>> findListOfCurrentCoursesForTeacher(int id) {
        Map<Course, List<Student>> globalMap = new HashMap<>();
        DaoStudent studentDao = daoFactory.createStudentDao();
        List<Course> currentCourseList = findListOfCourses(CourseQueryConstants.TEACHER_SELECT_CURRENT_COURSES, id);
        if (currentCourseList==null) {
            return null;
        }
        else {
            for (Course course : currentCourseList) {
                List<Student> studentList = studentDao.findAll(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES, course.getId());
                globalMap.put(course, studentList);
            }
        }
        return globalMap;
    }

}
