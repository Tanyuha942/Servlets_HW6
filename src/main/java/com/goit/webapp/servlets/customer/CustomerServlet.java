package com.goit.webapp.servlets.customer;

import com.goit.model.Customer;
import com.goit.service.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {

  private CustomerService service;

  @Override
  public void init() {
    this.service = (CustomerService) getServletContext().getAttribute("customerService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String deleteId = req.getParameter("deleteId");
    if (deleteId != null) {
      Customer customer = new Customer();
      customer.setId(Long.parseLong(deleteId));
      service.delete(customer);
      resp.sendRedirect("/customers");
    } else {
      List<Customer> all = service.getAll();
      req.setAttribute("customers", all);
      req.getRequestDispatcher("/jsp/customers.jsp").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Optional<Customer> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Customer.class);
    modelFromStream.ifPresent(customer -> service.create(customer));
    resp.sendRedirect("/customers");
  }
}