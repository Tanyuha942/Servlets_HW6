package com.goit.webapp.servlets.skill;

import com.goit.model.Skill;
import com.goit.service.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/skills")
public class SkillServlet extends HttpServlet {

  private SkillService service;

  @Override
  public void init() {
    this.service = (SkillService) getServletContext().getAttribute("skillService");
  }

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String deleteId = req.getParameter("deleteId");
    if (deleteId != null) {
      Skill skill = new Skill();
      skill.setId(Long.parseLong(deleteId));
      service.delete(skill);
      resp.sendRedirect("/skills");
    } else {
      List<Skill> all = service.getAll();
      req.setAttribute("skills", all);
      req.getRequestDispatcher("/jsp/skills.jsp").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Optional<Skill> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Skill.class);
    modelFromStream.ifPresent(skill -> service.create(skill));
    resp.sendRedirect("/skills");
  }
}