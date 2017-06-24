package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.view.AddressConstants;

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
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Student currentStudent = service.checkAndRegUser(firstName, lastName,login,password,email);
        session.setAttribute("participant", currentStudent);
        List<Course> accessableCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN, currentStudent.getId(),1);
        request.setAttribute("accessableCourseList1", accessableCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_NEW_COURSE_LIST).forward(request, response);
    }
    }

