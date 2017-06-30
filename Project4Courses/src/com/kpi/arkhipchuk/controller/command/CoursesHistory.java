package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.model.dao.jdbc.QueryConstants.StudentQueryConstants;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anya on 13.06.2017.
 */
public class CoursesHistory extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseName = request.getParameter(RequestConstants.PARAM_COURSE_NAME);
        request.setAttribute("courseName", courseName);
        int courseId = Integer.parseInt(request.getParameter(RequestConstants.PARAM_COURSE_ID));
        List<ArrayList<Object>> historyList = service.findListOfSpecificStrings(StudentQueryConstants.COURSES_HISTORY, courseId);
        request.setAttribute("historyList", historyList);
        request.getServletContext().getRequestDispatcher(AddressConstants.COURSES_HISTORY).forward(request, response);
    }
}
