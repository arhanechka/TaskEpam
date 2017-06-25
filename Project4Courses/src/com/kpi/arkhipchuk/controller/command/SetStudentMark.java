package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.view.AddressConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anya on 16.06.2017.
 */
public class SetStudentMark extends com.kpi.arkhipchuk.controller.command.Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mark = request.getParameter("mark");
        request.setAttribute("mark", mark);
        String courseName = request.getParameter("courseName");
        request.setAttribute("courseName", courseName);

        int studentId=Integer.parseInt(request.getParameter("studentId"));
        String comment = request.getParameter("comment");
        int courseId=Integer.parseInt(request.getParameter("courseId"));
        request.setAttribute("courseId", courseId);

        request.setAttribute("comment", comment);
        service.setStudentMark(mark,comment,studentId,courseId);
        List<Student> studentListForCurrentCourse = service.findListOfStudentForCourses(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES, courseId);
        request.setAttribute("studentListForCurrentCourse", studentListForCurrentCourse);
        request.getServletContext().getRequestDispatcher(AddressConstants.CURRENT_COURSE_STUDENT_LIST).forward(request, response);

    }
}
