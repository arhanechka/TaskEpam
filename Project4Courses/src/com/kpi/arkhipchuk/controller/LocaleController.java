package com.kpi.arkhipchuk.controller;

import com.kpi.arkhipchuk.controller.command.Command;
import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;

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
public class LocaleController extends Command {
    public static final String PARAM_LOCALE = "locale";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TRANSLATE_BUNDLE_NAME = "resources/translate";
        String page = request.getParameter(RequestConstants.PARAM_PAGE);
        String locale = request.getParameter(PARAM_LOCALE);
        HttpSession session = request.getSession(false);
        session.setAttribute("locale", locale);
        ResourceBundle bundle = ResourceBundle.getBundle(TRANSLATE_BUNDLE_NAME,
                new Locale(locale));
        for (Enumeration e = bundle.getKeys(); e.hasMoreElements(); ) {
            String key = (String) e.nextElement();
            String value = bundle.getString(key);
            session.setAttribute(key, value);
        }
        if (session.getAttribute("participant") == null) {
            request.getServletContext().getRequestDispatcher(AddressConstants.INDEX_LOCALED).forward(request, response);
        } else
            request.getServletContext().getRequestDispatcher(AddressConstants.INDEX_LOGGED).forward(request, response);
    }
}
