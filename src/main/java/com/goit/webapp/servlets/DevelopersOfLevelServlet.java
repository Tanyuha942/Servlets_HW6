package com.goit.webapp.servlets;

import com.goit.model.*;
import com.goit.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/developers_level")
public class DevelopersOfLevelServlet extends HttpServlet {

    private SkillService service;
    private List<Developer> developersLevel = new ArrayList<>();

    @Override
    public void init() {
        this.service = (SkillService) getServletContext().getAttribute("skillService");
    }

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSkill", service.getAll());
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("developersLevel", developersLevel);
        req.getRequestDispatcher("/jsp/developers_level.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Skill> modelFromStream = HandleBodyUtil.
                getModelFromStream(req.getInputStream(), Skill.class);
        modelFromStream.ifPresent(skill -> {
            developersLevel = DeveloperService.getInstance().getDevelopersOfLevel(skill.getLevel());
        });
        resp.sendRedirect("/developers_level");
    }
}