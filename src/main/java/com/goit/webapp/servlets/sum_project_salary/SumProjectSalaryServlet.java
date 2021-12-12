package com.goit.webapp.servlets.sum_project_salary;

import com.goit.model.SumProjectSalary;
import com.goit.service.SumProjectSalaryService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/salaries")
public class SumProjectSalaryServlet extends HttpServlet {

  private SumProjectSalaryService service;

  @Override
  public void init() {
    this.service = (SumProjectSalaryService) getServletContext()
        .getAttribute("sumProjectSalaryService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestURI = req.getRequestURI();
    String projectName = requestURI.substring(9);
    if (!"".equalsIgnoreCase(projectName)) {
      req.setAttribute("salary", service.getSumProjectSalary(projectName));
    }
    else {
      List<SumProjectSalary> all = service.getAll();
      req.setAttribute("salaries", all);
      req.getRequestDispatcher("/jsp/salaries.jsp").forward(req, resp);
    }
  }
}