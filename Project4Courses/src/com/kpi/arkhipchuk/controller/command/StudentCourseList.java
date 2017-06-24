package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Mark;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.view.AddressConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Anya on 07.06.2017.
 */
public class StudentCourseList extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Student currentStudent;
        if (session.getAttribute("participant")==null){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        if(!login.matches(RegEaxpressions.ALL_NAMES_REGEX)){
//            response.getWriter().append("error");
//            return;
//        }
//        if(!password.matches(RegEaxpressions.PASSWORD_REGEX)){
//            response.getWriter().append("error");
//            return;
//        }

        currentStudent = service.checkStudent(email,password);
        session.setAttribute("participant", currentStudent);}
        else {
            currentStudent=(Student)session.getAttribute("participant");
        }
        List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_CURRENT_COURSES, currentStudent.getId());
        request.setAttribute("currentCourseList1", currentCourseList);
        List<Course> accessableCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN, currentStudent.getId(),1);
        request.setAttribute("accessableCourseList1", accessableCourseList);
        Map<String,Mark> finishedCourseList = service.findListOfTwoStrings(CourseQueryConstants.STUDENT_SELECT_FINISHED_COURSES, currentStudent.getId());
        request.setAttribute("finishedCourseList1", finishedCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_COURSE_LIST).forward(request, response);
    }
}
