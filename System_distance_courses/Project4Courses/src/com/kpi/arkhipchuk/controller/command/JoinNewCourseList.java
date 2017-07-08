package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.entity.Course;
import com.kpi.arkhipchuk.model.entity.Student;
import com.kpi.arkhipchuk.services.CourseService;
import com.kpi.arkhipchuk.services.Service;
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
 * Servlet for join to accessable course by student
 */
public class JoinNewCourseList extends Command {
    private static final Logger LOGGER = LogManager.getLogger(JoinNewCourseList.class.getName());
    CourseService courseService = CourseService.getInstance();
    Service service = Service.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
        Student currentStudent = (Student) session.getAttribute(RequestConstants.PARAM_PARTICIPANT);
        int currentStudentId = currentStudent.getId();
        courseService.updateCourseStatusForJoin(currentStudentId, courseId);
        LOGGER.info("Status of course " + courseId + "was updated");
        List<Course> currentCourseList = courseService.getListOfCurrentCoursesForStudent(currentStudent.getId());
        request.setAttribute("currentCourseList1", currentCourseList);
        List<Course> accessableCourseList = courseService.getListOfAccessableCoursesForStudent(currentStudent.getId(), 1);
        request.setAttribute("accessableCourseList1", accessableCourseList);
        LOGGER.info("Accessable course list was created repeatedly");
        Map<String, String> finishedCourseList = courseService.findListOfFinishedCoursesAndMarks(currentStudent.getId());
        LOGGER.info("Finished course list was created repeatedly");
        request.setAttribute("finishedCourseList1", finishedCourseList);
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_COURSE_LIST).forward(request, response);
    }
}

