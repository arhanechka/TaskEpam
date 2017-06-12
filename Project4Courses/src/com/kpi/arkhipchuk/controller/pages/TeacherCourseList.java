package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
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
public class TeacherCourseList extends Command {
    @Override
    public void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Teacher currentTeacher = service.checkTeacher(login,password);
        String greeting = "Hello, "+ currentTeacher.getFirstName()+" "+currentTeacher.getLastName();
        request.setAttribute("greeting", greeting);
        Map<Course, List<Student>> currentCourseList = service.findListOfCurrentCoursesForTeacher(currentTeacher.getId());
        request.setAttribute("currentCourseList", currentCourseList);
//        request.setAttribute("ifLoginSuccessfull", ifStudentExists);
        request.getServletContext().getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request, response);
    }
}
