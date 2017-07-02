package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Teacher;
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
 * Created by Anya on 07.06.2017.
 */
public class TeacherCourseList extends Command {
    private static final Logger LOGGER = LogManager.getLogger(TeacherCourseList.class.getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Teacher currentTeacher;
        if (session.getAttribute(RequestConstants.PARAM_PARTICIPANT) == null) {
            String email = request.getParameter(RequestConstants.PARAM_EMAIL);
            String password = request.getParameter(RequestConstants.PARAM_PASSWORD);
            currentTeacher = service.checkTeacher(email, password);
            session.setAttribute("participant", currentTeacher);
            LOGGER.info("Teacher " +currentTeacher.getLastName()+" opened the session");
        } else {
            currentTeacher = (Teacher) session.getAttribute(RequestConstants.PARAM_PARTICIPANT);
            LOGGER.info("Session is exist for teacher " +currentTeacher.getLastName());
        }
        List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_CURRENT_COURSES, currentTeacher.getId());
        request.setAttribute("currentCourseList", currentCourseList);
        List<Course> inactiveCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION, currentTeacher.getId());
        request.setAttribute("inactiveCourseList", inactiveCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request, response);
    }
}
