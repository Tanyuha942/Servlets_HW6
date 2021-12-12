package com.goit.webapp.servlets.project_developers;

import com.goit.model.ProjectDeveloper;
import com.goit.service.ProjectDeveloperService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/devs")
public class ProjectDeveloperServlet extends HttpServlet {

  private ProjectDeveloperService service;

  @Override
  public void init() {
    this.service = (ProjectDeveloperService) getServletContext()
        .getAttribute("projectDeveloperService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestURI = req.getRequestURI();
    String projectName = requestURI.substring(5);
    if (!"".equalsIgnoreCase(projectName)) {
      req.setAttribute("dev", service.getProjectDevelopers(projectName));
    }
    else {
      List<ProjectDeveloper> all = service.getAll();
      req.setAttribute("devs", all);
      req.getRequestDispatcher("/jsp/devs.jsp").forward(req, resp);
    }
  }
}