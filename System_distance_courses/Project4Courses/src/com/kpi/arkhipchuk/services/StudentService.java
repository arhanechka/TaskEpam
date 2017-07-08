package com.kpi.arkhipchuk.services;

import com.kpi.arkhipchuk.model.dao.DaoFactory;
import com.kpi.arkhipchuk.model.dao.DaoStudent;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Anya on 05.07.2017.
 */
public class StudentService {

    private static volatile StudentService instance;
    DaoFactory daoFactory ;
    private static final Logger LOGGER = LogManager.getLogger(StudentService.class.getName());
    public final String USER_EXIST_EXCEPTION = "The user data inputed is exist in the our database!";

    public StudentService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    public static StudentService getInstance() {
        StudentService localInstance = instance;
        if (localInstance == null) {
            synchronized (StudentService.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new StudentService(DaoFactory.getFactory());
                }
            }
        }
        return localInstance;
    }

    public Student checkStudent(String email, String password) {
        DaoStudent studentDao = daoFactory.createStudentDao();
        Student student = studentDao.getStudentByEmail(email, password);
        return student;
    }



    public Student checkAndRegUser(String firstName, String lastName, String login, String password, String email) throws UserIsAlreadyExistException {
        DaoStudent studentDao = daoFactory.createStudentDao();
        if (!studentDao.ifStudentExist(StudentQueryConstants.STUDENT_SELECT_BY_EMAIL, email)) {
            LOGGER.error(USER_EXIST_EXCEPTION);
            throw new UserIsAlreadyExistException();
        }
        return studentDao.getNewStudent(firstName, lastName, login, password, email);
    }

    public List<Student> findListOfStudentForCourses(int id) {
        DaoStudent studentDao = daoFactory.createStudentDao();
        return studentDao.findAll(id);

    }

}
