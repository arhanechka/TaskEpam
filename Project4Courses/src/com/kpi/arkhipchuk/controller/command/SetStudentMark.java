package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anya on 16.06.2017.
 */
public class SetStudentMark extends com.kpi.arkhipchuk.controller.command.Command {
    public static final String PARAM_MARK = "mark";
    public static final String PARAM_STUDENT_ID = "studentId";
    public static final String PARAM_COMMENT = "comment";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String mark = request.getParameter(PARAM_MARK);
        request.setAttribute("mark", mark);
        Course currentCourse = (Course) session.getAttribute(RequestConstants.PARAM_CURRENT_COURSE);
        int studentId = Integer.parseInt(request.getParameter(PARAM_STUDENT_ID));
        String comment = request.getParameter(PARAM_COMMENT);
        request.setAttribute("comment", comment);
        service.setStudentMark(mark, comment, studentId, currentCourse.getId());
        List<Student> studentListForCurrentCourse = service.findListOfStudentForCourses(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES, currentCourse.getId());
        request.setAttribute("studentListForCurrentCourse", studentListForCurrentCourse);
        request.getServletContext().getRequestDispatcher(AddressConstants.CURRENT_COURSE_STUDENT_LIST).forward(request, response);

    }
}
