package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.services.Service;
import com.kpi.arkhipchuk.services.StudentService;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet for setting of marks for students of choosen course by teacher
 */
public class SetStudentMark extends Command {
    public static final String PARAM_MARK = "mark";
    public static final String PARAM_STUDENT_ID = "studentId";
    public static final String PARAM_COMMENT = "comment";
    private static final Logger LOGGER = LogManager.getLogger(SetStudentMark.class.getName());
    StudentService studentService = StudentService.getInstance();
Service service = Service.getInstance();

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
        LOGGER.info("Mark "+mark +" for student "+studentId+" was added");
        List<Student> studentListForCurrentCourse = studentService.findListOfStudentForCourses(currentCourse.getId());
        LOGGER.info("studentListForCurrentCourse was builded repeatedly");
        request.setAttribute("studentListForCurrentCourse", studentListForCurrentCourse);
        request.getServletContext().getRequestDispatcher(AddressConstants.CURRENT_COURSE_STUDENT_LIST).forward(request, response);

    }
}
