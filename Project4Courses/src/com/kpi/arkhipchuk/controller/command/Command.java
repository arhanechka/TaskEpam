package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.controller.Service;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 06.06.2017.
 */
public abstract class Command {
    Service service = Service.getInstance();

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserIsAlreadyExistException;
}
