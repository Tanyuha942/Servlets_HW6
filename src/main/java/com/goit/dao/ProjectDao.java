package com.goit.dao;

import com.goit.model.Project;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.apache.logging.log4j.*;

public class ProjectDao extends AbstractDao<Project> {

  private static final Logger LOGGER = LogManager.getLogger(ProjectDao.class);
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

  private static ProjectDao instance;

  private ProjectDao() {
  }

  public static ProjectDao getInstance() {
    if (instance == null) {
      instance = new ProjectDao();
    }
    return instance;
  }

  @Override
  String getTableName() {
    return "projects";
  }

  @Override
  Project mapToEntity(ResultSet rs) throws SQLException {
    Project project = new Project();
    project.setId(rs.getLong("id"));
    project.setName(rs.getString("project_name"));
    project.setCreated(format.format(rs.getDate("created")));
    project.setCost(rs.getDouble("cost"));
    return project;
  }

  @Override
  public Optional<Project> create(Project project) {
    String sql = "insert into projects(project_name, created, cost)"
        + " values(?, ?, ?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      System.out.println("ps: " + ps);
      ps.setString(1, project.getName());
      if (project.getCreated() != null) {
        ps.setDate(2, new Date(Date.valueOf(project.getCreated()).getTime()));
      } else { ps.setDate(2, null); }
      ps.setDouble(3, project.getCost());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Project project) {
    String sql = "update projects set project_name = ?, created = ?, cost = ?"
        + " where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, project.getName());
      if (project.getCreated() != null) {
        ps.setDate(2, new Date(Date.valueOf(project.getCreated()).getTime()));
      } else { ps.setDate(2, null); }
      ps.setDouble(3, project.getCost());
      ps.setLong(4, project.getId());
    });
    LOGGER.info("Record was updated");
  }
}