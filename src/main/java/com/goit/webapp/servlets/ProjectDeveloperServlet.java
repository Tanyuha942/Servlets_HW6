package com.goit.webapp.servlets;

import com.goit.model.*;
import com.goit.service.*;
import org.apache.logging.log4j.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/project_developers")
public class ProjectDeveloperServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(ProjectDeveloperServlet.class);
    private ProjectService service;
    private List<Developer> projectDeveloper = new ArrayList<>();
    String projectName;

    @Override
    public void init() {
        this.service = (ProjectService) getServletContext().getAttribute("projectService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listProject", service.getAll());
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("listProjectDevelopers", projectDeveloper);
        req.setAttribute("projectName", projectName);
        req.getRequestDispatcher("/jsp/project_developers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Project> modelFromStream = HandleBodyUtil.
                getModelFromStream(req.getInputStream(), Project.class);
        modelFromStream.ifPresent(p -> {
                    projectName = ProjectService.getInstance().getProjectName(p);
                }
        );
        modelFromStream.ifPresent(project -> {
            try {
                projectDeveloper = DeveloperService.getInstance().getProjectDevelopers(project.getName());
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        });
        resp.sendRedirect("/project_developers");
    }
}