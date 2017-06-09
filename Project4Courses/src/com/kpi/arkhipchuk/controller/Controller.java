package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.controller.pages.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
    private static Map<String, Page> pages = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        pages.put("NEW_STUDENT", new StudentRegPage());
        pages.put("LOGIN_TEACHER", new TeacherLoginPage());
        pages.put("LOGIN_STUDENT", new StudentLoginPage());
        pages.put("LIST_COURSE_STUDENT", new StudentCourseList());
        pages.put("LIST_COURSE_TEACHER", new TeacherCourseList());
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
            pages.get(page).launch(request, response);
        } catch (RuntimeException ex) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }
    }
}
