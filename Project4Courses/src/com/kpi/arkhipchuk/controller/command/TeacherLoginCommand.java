package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.view.AddressConstants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 06.06.2017.
 */
public class TeacherLoginCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher(AddressConstants.TEACHER_LOGIN_PAGE).forward(request, response);

    }
}
