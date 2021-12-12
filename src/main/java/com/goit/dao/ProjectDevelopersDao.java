package com.goit.dao;

import com.goit.model.ProjectDeveloper;
import java.sql.*;
import java.util.*;
import java.util.Optional;
import org.apache.logging.log4j.*;

public class ProjectDevelopersDao extends AbstractDao<ProjectDeveloper> {

  private static final Logger LOGGER = LogManager.getLogger(ProjectDevelopersDao.class);
  private static ProjectDevelopersDao instance;

  private ProjectDevelopersDao() {
  }

  public static ProjectDevelopersDao getInstance() {
    if (instance == null) {
      instance = new ProjectDevelopersDao();
    }
    return instance;
  }


  @Override
  String getTableName() {
    return "list_developers_of_project";
  }

  @Override
  ProjectDeveloper mapToEntity(ResultSet rs) throws SQLException {
    ProjectDeveloper projectDeveloper = new ProjectDeveloper();
    projectDeveloper.setProjectName(rs.getString("project_name"));
    projectDeveloper.setDeveloper(rs.getString("developer_name"));
    return projectDeveloper;
  }

  public List<ProjectDeveloper> getProjectDevelopers(String projectName) {
    String query = "select * from list_developers_of_project where project_name = ?";
    List<ProjectDeveloper> resultList = new ArrayList<>();
    try {
      ResultSet resultSet = DbHelper.getWithPreparedStatement(
          query, ps -> {
            ps.setString(1, projectName);
          });
      while (resultSet.next()) {
        LOGGER.debug("Record was selected");
        resultList.add(mapToEntity(resultSet));
      }
    } catch (SQLException e) {
      LOGGER.error(e);
    }
    return resultList;
  }

  @Override
  public Optional<ProjectDeveloper> create(ProjectDeveloper entity) {
    return Optional.empty();
  }

  @Override
  public void update(ProjectDeveloper entity) {

  }
}