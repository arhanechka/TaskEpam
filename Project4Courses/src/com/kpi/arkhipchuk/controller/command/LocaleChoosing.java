package com.kpi.arkhipchuk.controller.command;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by Anya on 25.06.2017.
 */
public class LocaleChoosing extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TRANSLATE_BUNDLE_NAME = "resources/translate";
        String page = request.getParameter("page");
        String locale = request.getParameter("locale");
        HttpSession session = request.getSession(false);
        session.setAttribute("locale", locale);
        ResourceBundle bundle = ResourceBundle.getBundle(TRANSLATE_BUNDLE_NAME,
                new Locale(locale));
        for (Enumeration e = bundle.getKeys(); e.hasMoreElements();) {
            String key = (String)e.nextElement();
            String s = bundle.getString(key);
            session.setAttribute(key,s);
        }
        if (session.getAttribute("participant")==null){
        request.getServletContext().getRequestDispatcher("/index_loc.jsp").forward(request, response);
        }
        else
            request.getServletContext().getRequestDispatcher("/logged_index.jsp").forward(request, response);
    }
}
