package com.kpi.arkhipchuk.controller.command;

import com.kpi.arkhipchuk.controller.Service;
/*import org.apache.log4j.Logger;*/

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anya on 06.06.2017.
 */
public abstract class Command {
  //  private static final Logger LOG = Logger.getLogger(Command.class);

    Service service = Service.getInstance();
  //  public Logger log = Logger.getLogger(Command.class.getName());

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
