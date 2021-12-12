package com.goit.webapp.servlets.project_info;

import com.goit.model.ProjectInfo;
import com.goit.service.ProjectInfoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/info")
public class ProjectInfoServlet extends HttpServlet {

  private ProjectInfoService service;

  @Override
  public void init() {
    this.service = (ProjectInfoService) getServletContext().getAttribute("projectInfoService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<ProjectInfo> all = service.getAll();
    req.setAttribute("info", all);
    req.setCharacterEncoding("UTF-8");
    req.getRequestDispatcher("/jsp/info.jsp").forward(req, resp);
  }
}