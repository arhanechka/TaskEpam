package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
//import org.apache.log4j.Logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Anya on 25.06.2017.
 */
public class CloseCourse extends Command {
    public static final String PARAM_ERROR_CLOSING_COURSE = "error_closing_course";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Teacher currentTeacher = (Teacher) session.getAttribute(RequestConstants.PARAM_PARTICIPANT);
        Course currentCourse = (Course) session.getAttribute(RequestConstants.PARAM_CURRENT_COURSE);
        List<Student> studentListForCurrentCourse = service.findListOfStudentForCourses(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES, currentCourse.getId());
        if (studentListForCurrentCourse == null) {
            service.updateCourseStatus(CourseQueryConstants.TEACHER_UPDATE_COURSES_FOR_ACTIVATION, 0, currentCourse.getId());
            List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_CURRENT_COURSES, currentTeacher.getId());
            request.setAttribute("currentCourseList", currentCourseList);
            List<Course> inactiveCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION, currentTeacher.getId());
            request.setAttribute("inactiveCourseList", inactiveCourseList);
        } else {
            String errorMessage = (String) session.getAttribute(PARAM_ERROR_CLOSING_COURSE);
            request.setAttribute("message", errorMessage);
            request.setAttribute("backButton", AddressConstants.BACK_BUTTON + currentCourse.getId() + "&courseName=" + currentCourse.getName());
            request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request, response);
            //  logger.info("Trying to close course with students");
        }
        request.getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request, response);
    }
}
