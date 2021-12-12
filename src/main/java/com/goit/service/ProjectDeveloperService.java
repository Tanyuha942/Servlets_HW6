package com.goit.service;

import com.goit.dao.ProjectDevelopersDao;
import com.goit.model.ProjectDeveloper;
import java.util.List;
import org.apache.logging.log4j.*;

public class ProjectDeveloperService {

  private static ProjectDeveloperService instance;
  private static final Logger LOGGER = LogManager.getLogger(ProjectDeveloperService.class);
  private static final ProjectDevelopersDao projectDevelopersDao = ProjectDevelopersDao.getInstance();

  private ProjectDeveloperService() {
  }

  public static ProjectDeveloperService getInstance() {
    if (instance == null) {
      instance = new ProjectDeveloperService();
    }
    return instance;
  }

  public List<ProjectDeveloper> getAll() {
    return projectDevelopersDao.getAll();
  }

  public List<ProjectDeveloper> getProjectDevelopers(String projectName) {
    return projectDevelopersDao.getProjectDevelopers(projectName);
  }
}