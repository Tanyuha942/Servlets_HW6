package com.goit.webapp.servlets.java_developers;

import com.goit.model.JavaDeveloper;
import com.goit.service.JavaDeveloperService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/java")
public class JavaDeveloperServlet extends HttpServlet {

  private JavaDeveloperService service;

  @Override
  public void init() {
    this.service = (JavaDeveloperService) getServletContext().getAttribute("javaDeveloperService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<JavaDeveloper> all = service.getAll();
      req.setAttribute("java", all);
      req.setCharacterEncoding("UTF-8");
      req.getRequestDispatcher("/jsp/java.jsp").forward(req, resp);
    }
}