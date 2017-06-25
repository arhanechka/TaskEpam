package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.controller.command.*;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.ErrorMessages;

import javax.naming.Context;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anya on 05.06.2017.
 */
//@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Map<String, Command> commands = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
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
        commands.put("LOCALE_CHOOSING", new LocaleChoosing());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String page = request.getParameter("page");
        try {
            commands.get(page).execute(request, response);
        } catch (RuntimeException ex) {
            request.setAttribute("message", ErrorMessages.COMMON_ERROR);
            request.setAttribute("backButton", "/index.jsp");
            request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request, response);
        }
    }
}
