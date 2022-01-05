package com.goit.webapp.servlets;

import com.goit.model.*;
import com.goit.service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/developers_industry")
public class DevelopersOfIndustryServlet extends HttpServlet {
    private SkillService service;
    private List<Developer> developersIndustry = new ArrayList<>();

    @Override
    public void init() {
        this.service = (SkillService) getServletContext().getAttribute("skillService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSkill", service.getAll());
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("developersIndustry", developersIndustry);
        req.getRequestDispatcher("/jsp/developers_industry.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Skill> modelFromStream = HandleBodyUtil.
                getModelFromStream(req.getInputStream(), Skill.class);
        modelFromStream.ifPresent(skill -> {
            developersIndustry = DeveloperService.getInstance().getDevelopersOfIndustry(skill.getIndustry());
        });
        resp.sendRedirect("/developers_industry");
    }
}