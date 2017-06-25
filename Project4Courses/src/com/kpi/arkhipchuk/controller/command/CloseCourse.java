package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.model.entity.Teacher;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.ErrorMessages;

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
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Teacher currentTeacher=(Teacher) session.getAttribute("participant");
        Course currentCourse =(Course) session.getAttribute("currentCourse");
        List<Student> studentListForCurrentCourse = service.findListOfStudentForCourses(CourseQueryConstants.TEACHER_SELECT_LIST_OF_STUDENTS_FOR_CURRENT_COURSES, currentCourse.getId());
        if (studentListForCurrentCourse==null){
            service.updateCourseStatus(CourseQueryConstants.TEACHER_UPDATE_COURSES_FOR_ACTIVATION, 0, currentCourse.getId());
            List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_CURRENT_COURSES, currentTeacher.getId());
            request.setAttribute("currentCourseList", currentCourseList);
            List<Course> inactiveCourseList = service.findListOfCourses(CourseQueryConstants.TEACHER_SELECT_INACTIVE_COURSES_FOR_ACTIVATION, currentTeacher.getId());
            request.setAttribute("inactiveCourseList", inactiveCourseList);
        }
        else{
            request.setAttribute("message", ErrorMessages.CLOSE_COURSE_ERROR);
            request.setAttribute("backButton", "./Controller?page=STUDENTS_LIST_FOR_CURRENT_COURSE&courseId="+currentCourse.getId()+"&courseName="+currentCourse.getName());
            request.getRequestDispatcher(AddressConstants.ERROR_PAGE).forward(request,response);
        }

        request.getRequestDispatcher(AddressConstants.TEACHER_COURSE_LIST).forward(request,response);
    }
}