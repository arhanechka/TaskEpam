package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.services.CourseService;
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
 * Servlet for presentation of students list of current course for teacher
 */
public class StudentsListForCurrentCourse extends Command {
    private static final Logger LOGGER = LogManager.getLogger(StudentsListForCurrentCourse.class.getName());
    CourseService courseService = CourseService.getInstance();
    StudentService studentService = StudentService.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Course currentCourse;
        if (session.getAttribute(RequestConstants.PARAM_CURRENT_COURSE) == null) {
            int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
            currentCourse = courseService.getCourseById(courseId);
            session.setAttribute("currentCourse", currentCourse);
            LOGGER.info("New current course was added");
        } else if ((currentCourse = (Course) session.getAttribute(RequestConstants.PARAM_CURRENT_COURSE)).getId() != Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID))) {
            currentCourse = courseService.getCourseById(Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID)));
            session.setAttribute("currentCourse", currentCourse);
            LOGGER.info("Current course was selected from database");
        } else {
            currentCourse = (Course) session.getAttribute(RequestConstants.PARAM_CURRENT_COURSE);
        }
        List<Student> studentListForCurrentCourse = studentService.findListOfStudentForCourses(currentCourse.getId());
        request.setAttribute("studentListForCurrentCourse", studentListForCurrentCourse);
        request.getServletContext().getRequestDispatcher(AddressConstants.CURRENT_COURSE_STUDENT_LIST).forward(request, response);

    }
}
