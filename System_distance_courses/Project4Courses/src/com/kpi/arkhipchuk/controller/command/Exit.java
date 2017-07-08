package com.kpi.arkhipchuk.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet for closing a session
 */
public class Exit extends Command {
    private static final Logger LOGGER = LogManager.getLogger(Exit.class.getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("participant", null);
        LOGGER.info("Session was finished succesfully");
        request.getRequestDispatcher("./index.jsp").forward(request,response);
    }
}
