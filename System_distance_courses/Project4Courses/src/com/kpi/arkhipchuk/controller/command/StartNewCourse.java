package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Teacher;
import com.kpi.arkhipchuk.services.CourseService;
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
 * Servlet for activation of course by teacher
 */
public class StartNewCourse extends Command {
    private static final Logger LOGGER = LogManager.getLogger(StartNewCourse.class.getName());
    CourseService courseService = CourseService.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
        String courseName = request.getParameter(RequestConstants.PARAM_COURSE_NAME);
        Teacher currentTeacher = (Teacher) session.getAttribute(RequestConstants.PARAM_PARTICIPANT);
        courseService.getUpdatedCourseStatusForTeacher(1, courseId);
        LOGGER.info("Course "+courseName+" was activated");
        List<Course> currentCourseList = courseService.getListOfCurrentCoursesForTeacher(currentTeacher.getId());
        request.setAttribute("currentCourseList", currentCourseList);
        LOGGER.info("currentCourseList was formed repeatedly");
        List<Course> inactiveCourseList = courseService.getListOfAccessableCoursesForTeacher(currentTeacher.getId());
        request.setAttribute("inactiveCourseList", inactiveCourseList);
        LOGGER.info("inactiveCourseList was formed repeatedly");
        request.getServletContext().getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request, response);

    }
}
