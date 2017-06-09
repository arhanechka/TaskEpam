package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.view.AddressConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 07.06.2017.
 */
public class StudentNewCourseList extends Page {
    @Override
    public void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Boolean ifStudentExists = service.checkAndRegUser(firstName, lastName,login,password,email);
        String ifLoginSuccessful;
        if (ifStudentExists==true){
            ifLoginSuccessful="Hello, "+login+"! You have been registred successful!";
        }
        else {
            ifLoginSuccessful="Please try again! Your login or password is incorrect!";
        }
        request.setAttribute("ifLoginSuccessful", ifLoginSuccessful);

        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_NEW_COURSE_LIST).forward(request, response);
    }
    }

