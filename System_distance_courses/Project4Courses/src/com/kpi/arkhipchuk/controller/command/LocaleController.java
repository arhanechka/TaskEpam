package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.view.AddressConstants;
import com.kpi.arkhipchuk.view.RequestConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Controller for locale choosing
 */
public class LocaleController extends Command {
    public static final String PARAM_LOCALE = "locale";
    private static final Logger LOGGER = LogManager.getLogger(LocaleController.class.getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String TRANSLATE_BUNDLE_NAME = "resources/translate";
        String page = request.getParameter(RequestConstants.PARAM_PAGE);
        String locale = request.getParameter(PARAM_LOCALE);
        HttpSession session = request.getSession(false);
        session.setAttribute("locale", locale);
        LOGGER.info("Locale choosen is "+locale);
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
