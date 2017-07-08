package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.services.Service;
import com.kpi.arkhipchuk.model.exceptions.UserIsAlreadyExistException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Abstract parent servlet which creates instance of Service.class
 */
public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserIsAlreadyExistException;
}
