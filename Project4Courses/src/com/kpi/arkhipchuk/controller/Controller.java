package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.controller.command.*;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
/*import org.apache.log4j.Logger;*/

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anya on 05.06.2017.
 */
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, Command> commands = new HashMap<>();
    public static final String PARAM_COMMON_ERROR = "common_error";


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
       // final Logger rootLogger = LogManager.getRootLogger();

        commands.put("NEW_STUDENT", new StudentRegCommand());
        commands.put("LOGIN_TEACHER", new TeacherLoginCommand());
        commands.put("LOGIN_STUDENT", new StudentLoginCommand());
        commands.put("LIST_COURSE_STUDENT", new StudentCourseList());
        commands.put("LIST_COURSE_TEACHER", new TeacherCourseList());
        commands.put("COURSES_HISTORY", new CoursesHistory());
        commands.put("STUDENT_NEW_COURSE_LIST", new StudentNewCourseList());
        commands.put("JOIN_NEW_COURSE_LIST", new JoinNewCourseList());
        commands.put("START_NEW_COURSE", new StarNewCourse());
        commands.put("STUDENTS_LIST_FOR_CURRENT_COURSE", new StudentsListForCurrentCourse());
        commands.put("SET_STUDENT_MARK", new SetStudentMark());
        commands.put("EXIT", new Exit());
        commands.put("CLOSE_COURSE", new CloseCourse());
        commands.put("LOCALE_CHOOSING", new LocaleController());
        commands.put("CREATE_NEW_COURSE", new CreateNewCourse());

//        rootLogger.debug("Command container was successfully initialized");
//        rootLogger.trace("Total number of commands equals to " + commands.size());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String page = request.getParameter(RequestConstants.PARAM_PAGE);
        try {
            commands.get(page).execute(request, response);
        } catch (RuntimeException ex) {
            request.setAttribute("message", session.getAttribute(PARAM_COMMON_ERROR));
            request.setAttribute("backButton", AddressConstants.INDEX);
            request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request, response);
        }
    }
}
