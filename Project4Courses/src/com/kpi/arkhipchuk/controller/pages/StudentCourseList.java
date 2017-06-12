package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Mark;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.view.AddressConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Anya on 07.06.2017.
 */
public class StudentCourseList extends Command {
    @Override
    public void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Student currentStudent = service.checkStudent(login,password);
        String greeting = "Hello, "+ currentStudent.getFirstName()+" "+currentStudent.getLastName();
        request.setAttribute("greeting", greeting);
        List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_CURRENT_COURSES, currentStudent.getId());
        request.setAttribute("currentCourseList", currentCourseList);
        List<Course> accessableCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN, currentStudent.getId(),1);
        request.setAttribute("accessableCourseList", accessableCourseList);
        Map<String,Mark> finishedCourseList = service.findListOfTwoStrings(CourseQueryConstants.STUDENT_SELECT_FINISHED_COURSES, currentStudent.getId());
        request.setAttribute("finishedCourseList", finishedCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_COURSE_LIST).forward(request, response);
    }
}
