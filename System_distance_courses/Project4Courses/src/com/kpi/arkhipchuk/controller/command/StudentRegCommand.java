package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.view.AddressConstants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for registration of new student
 */
public class StudentRegCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(AddressConstants.STUDENT_REG_PAGE).forward(request, response);
    }
}
