package com.goit.webapp.servlets.sum_project_salary;

import com.goit.model.SumProjectSalary;
import com.goit.service.SumProjectSalaryService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.logging.log4j.*;

@WebServlet("/salaries/*")
public class ViewSumProjectSalaryServlet extends HttpServlet {

  public static final Logger LOGGER = LogManager.getLogger(ViewSumProjectSalaryServlet.class);
  private SumProjectSalaryService service;

  @Override
  public void init() throws ServletException {
    this.service = (SumProjectSalaryService) getServletContext().getAttribute("sumProjectSalaryService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String requestURI = req.getRequestURI();
    String projectName = requestURI.replace("/salaries/", "");
    List<SumProjectSalary> salaryList = service.getSumProjectSalary(projectName);
    if (salaryList.size() > 0) {
      req.setAttribute("salary", salaryList);
      req.getRequestDispatcher("/jsp/salary.jsp").forward(req, resp);
    }
    resp.sendRedirect("/salaries");
  }
}