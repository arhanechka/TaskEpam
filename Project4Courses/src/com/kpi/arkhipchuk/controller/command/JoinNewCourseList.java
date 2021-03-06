package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.CourseQueryConstants;
import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Mark;
import com.kpi.arkhipchuk.model.entity.Student;
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
import java.util.Map;

/**
 * Created by Anya on 15.06.2017.
 */
public class JoinNewCourseList extends Command {
    private static final Logger LOGGER = LogManager.getLogger(JoinNewCourseList.class.getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
        Student currentStudent = (Student) session.getAttribute(RequestConstants.PARAM_PARTICIPANT);
        int currentStudentId = currentStudent.getId();
        service.updateCourseStatus(CourseQueryConstants.STUDENT_UPDATE_FOR_JOIN_TO_NEW_COURSE, currentStudentId, courseId);
        LOGGER.info("Status of course "+ courseId +"was updated");
        List<Course> currentCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_CURRENT_COURSES, currentStudent.getId());
        request.setAttribute("currentCourseList1", currentCourseList);
        List<Course> accessableCourseList = service.findListOfCourses(CourseQueryConstants.STUDENT_SELECT_ACTUAL_COURSES_FOR_JOIN, currentStudent.getId(), 1);
        request.setAttribute("accessableCourseList1", accessableCourseList);
        LOGGER.info("Accessable course list was created repeatedly");
        Map<String, Mark> finishedCourseList = service.findListOfTwoStrings(CourseQueryConstants.STUDENT_SELECT_FINISHED_COURSES, currentStudent.getId());
        LOGGER.info("Finished course list was created repeatedly");
        request.setAttribute("finishedCourseList1", finishedCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_COURSE_LIST).forward(request, response);
    }
}

