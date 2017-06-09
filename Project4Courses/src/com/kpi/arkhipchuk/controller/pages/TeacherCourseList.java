package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.view.AddressConstants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 07.06.2017.
 */
public class TeacherCourseList extends Page {
    @Override
    public void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
//        Boolean ifStudentExists = service.checkUser(login,password,"teacher");
        String ifLoginSuccessfull = service.checkUser("teacher", login, password);
//        if (ifStudentExists==true){
//            ifLoginSuccessfull="Hello, "+login+"!";
//        }
//        else {
//            ifLoginSuccessfull="Please try again! Your login or password is incorrect!";
//        }
        request.getServletContext().setAttribute("ifLoginSuccessfull", ifLoginSuccessfull);

        request.getServletContext().getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request, response);
    }
}
