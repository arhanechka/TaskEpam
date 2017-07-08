package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.services.Service;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet for presentation of course history with student list and marks
 */
public class CoursesHistory extends Command {
    private static final Logger LOGGER = LogManager.getLogger(CoursesHistory.class.getName());
    Service service = Service.getInstance();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter(RequestConstants.PARAM_COURSE_NAME);
        request.setAttribute("courseName", courseName);
        int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
        List<ArrayList<Object>> historyList =
                service.findListOfSpecificStrings(courseId);
        request.setAttribute("historyList", historyList);
        LOGGER.info("List of course history was build successfuly");
        request.getServletContext().getRequestDispatcher(AddressConstants.COURSES_HISTORY).forward(request, response);
    }
}
