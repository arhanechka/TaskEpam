package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.view.AddressConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 07.06.2017.
 */
public class StudentCourseList extends Page {
    @Override
    public void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String ifStudentExists = service.checkUser("student",login,password);
        String ifLoginSuccessfull=null;
//        if (ifStudentExists==true){
//            ifLoginSuccessfull="Hello, "+login+"!";
//        }
//        else {
//            ifLoginSuccessfull="Please try again! Your login or password is incorrect!";
//        }
        request.setAttribute("ifLoginSuccessfull", ifStudentExists);

        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_COURSE_LIST).forward(request, response);
    }
}
