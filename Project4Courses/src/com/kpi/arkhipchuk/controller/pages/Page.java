package com.kpi.arkhipchuk.controller.pages;

import com.kpi.arkhipchuk.controller.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 06.06.2017.
 */
public abstract class Page {
Service service = Service.getInstance();
    public abstract void launch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
