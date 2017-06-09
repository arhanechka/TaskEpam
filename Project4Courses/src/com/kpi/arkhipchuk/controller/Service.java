package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.dao.DaoCourse;
import com.kpi.arkhipchuk.dao.DaoFactory;
import com.kpi.arkhipchuk.dao.DaoStudent;
import com.kpi.arkhipchuk.dao.DaoTeacher;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;

/**
 * Created by Anya on 07.06.2017.
 */
public class Service {
    private static Service instance;
    private static DaoFactory daoFactory = DaoFactory.getFactory();
    private Service(){}

    public static Service getInstance(){
        if (instance==null){
            instance= new Service();}
        return instance;
    }
    public String checkUser(String table, String login, String password){
        String resultQuery=null;
        switch (table){
            case "teacher": {
                DaoTeacher teacherDao = daoFactory.createTeacherDao();
                Teacher teacher = teacherDao.find(login, password);
                resultQuery = "Hello, "+teacher.getLastName() + " " + teacher.getFirstName();
            }
            case "student":{
                DaoStudent studentDao = daoFactory.createStudentDao();
                Student student= studentDao.find(login, password);
                resultQuery = "Hello, "+student.getLastName()+" "+student.getFirstName();
            }
        }
       return resultQuery;
    }

    public String checkUserTeacher(String table, String login, String password){
                DaoTeacher teacherDao = daoFactory.createTeacherDao();
                Teacher teacher = teacherDao.find(login, password);
                return "Hello, "+teacher.getLastName() + " " + teacher.getFirstName();
            }
    public Boolean checkAndRegUser(String firstName, String lastName, String login, String password, String email){
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

//    public Course getCourseById(int id) {
//        DaoCourse courseDao = daoFactory.createCourseDao();
//        return courseDao.find(id);
//    }

}
