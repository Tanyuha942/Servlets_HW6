package com.goit.webapp.servlets.project_developers;

import com.goit.model.ProjectDeveloper;
import com.goit.service.ProjectDeveloperService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.logging.log4j.*;

@WebServlet("/devs/*")
public class ViewProjectDeveloperServlet extends HttpServlet {

  public static final Logger LOGGER = LogManager.getLogger(ViewProjectDeveloperServlet.class);
  private ProjectDeveloperService service;

  @Override
  public void init() throws ServletException {
    this.service = (ProjectDeveloperService) getServletContext().getAttribute("projectDeveloperService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestURI = req.getRequestURI();
    String projectName = requestURI.replace("/devs/", "");
    List<ProjectDeveloper> projectDevelopers = service.getProjectDevelopers(projectName);
    if (projectDevelopers.size() > 0) {
      req.setAttribute("dev", projectDevelopers);
      req.getRequestDispatcher("/jsp/dev.jsp").forward(req, resp);
    }
    resp.sendRedirect("/devs");
  }
}