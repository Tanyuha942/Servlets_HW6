package com.goit.webapp.servlets.middle_developer;

import com.goit.model.MiddleDeveloper;
import com.goit.service.MiddleDeveloperService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/middle")
public class MiddleDeveloperServlet extends HttpServlet {

  private MiddleDeveloperService service;

  @Override
  public void init() {
    this.service = (MiddleDeveloperService) getServletContext().getAttribute("middleDeveloperService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<MiddleDeveloper> all = service.getAll();
    req.setAttribute("middle", all);
    req.setCharacterEncoding("UTF-8");
    req.getRequestDispatcher("/jsp/middle.jsp").forward(req, resp);
  }
}
