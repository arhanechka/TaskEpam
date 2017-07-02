package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.UserDataChecking;
import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RegExpressions;
import com.kpi.arkhipchuk.view.RequestConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anya on 07.06.2017.
 */
public class StudentNewCourseList extends Command {
    private static final Logger LOGGER = LogManager.getLogger(StudentNewCourseList.class.getName());
    final String ERROR_DATA_FIRST_NAME = "error_data_first_name";
    final String ERROR_DATA_LAST_NAME = "error_data_last_name";
    final String ERROR_DATA_PASSWORD = "error_data_password";
    final String ERROR_DATA_EMAIL = "error_data_email";
    final String ERROR_USER_EXIST = "error_user_exist";
    String errorMessage = "";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserIsAlreadyExistException {
        String firstName = request.getParameter(RequestConstants.PARAM_FIRST_NAME);
        String lastName = request.getParameter(RequestConstants.PARAM_LAST_NAME);
        String login = request.getParameter(RequestConstants.PARAM_LOGIN);
        String password = request.getParameter(RequestConstants.PARAM_PASSWORD);
        String email = request.getParameter(RequestConstants.PARAM_EMAIL);
        HttpSession session = request.getSession(true);
        UserDataChecking userDataChecking = new UserDataChecking();
        Boolean ifDataMatch = true;
        if (!userDataChecking.inputAndCheckData(RegExpressions.ALL_NAMES_REGEX, firstName)) {
            ifDataMatch = false;
            LOGGER.error("User inputed wrong format of first name");
            errorMessage = (String) session.getAttribute(ERROR_DATA_FIRST_NAME);
        } else if (!userDataChecking.inputAndCheckData(RegExpressions.ALL_NAMES_REGEX, lastName)) {
            ifDataMatch = false;
            LOGGER.error("User inputed wrong format of last name");
            errorMessage = (String) session.getAttribute(ERROR_DATA_LAST_NAME);
        } else if (!userDataChecking.inputAndCheckData(RegExpressions.PASSWORD_REGEX, password)) {
            ifDataMatch = false;
            LOGGER.error("User inputed wrong format of password");
            errorMessage = (String) session.getAttribute(ERROR_DATA_PASSWORD);
        } else if (!userDataChecking.inputAndCheckData(RegExpressions.EMAIL_REGEX, email)) {
            ifDataMatch = false;
            LOGGER.error("User inputed wrong format of email");
            errorMessage = (String) session.getAttribute(ERROR_DATA_EMAIL);
        }
        if (ifDataMatch == true) {
            Student currentStudent = service.checkAndRegUser(firstName, lastName, login, password, email);
            if (currentStudent != null) {
                session.setAttribute("participant", currentStudent);
                LOGGER.info("New student "+currentStudent.getLastName()+" opened the session");
                List<Course> accessableCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN, currentStudent.getId(), 1);
                request.setAttribute("accessableCourseList1", accessableCourseList);
            } else {
                errorMessage = (String) session.getAttribute(ERROR_USER_EXIST);
                LOGGER.error(errorMessage);
                request.setAttribute("message", errorMessage);
                request.setAttribute("backButton", AddressConstants.DISPATCHER+AddressConstants.BACK_BUTTON_REGISTRATION);
                request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request, response);
            }
        } else {
            request.setAttribute("message", errorMessage);
            LOGGER.error(errorMessage);
            request.setAttribute("backButton",AddressConstants.DISPATCHER+AddressConstants.BACK_BUTTON_REGISTRATION);
            request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request, response);
        }
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_NEW_COURSE_LIST).forward(request, response);
    }
}

