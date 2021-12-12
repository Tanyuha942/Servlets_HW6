package com.goit.dao;

import com.goit.model.ProjectInfo;
import java.sql.*;
import java.util.Optional;

public class ProjectInfoDao extends AbstractDao<ProjectInfo> {


  @Override
  String getTableName() {
    return "list_of_projects";
  }

  @Override
  ProjectInfo mapToEntity(ResultSet rs) throws SQLException {
    ProjectInfo projectInfo = new ProjectInfo();
    projectInfo.setListProjects(rs.getString("list_projects"));
    return projectInfo;
  }

  @Override
  public Optional<ProjectInfo> create(ProjectInfo entity) {
    return Optional.empty();
  }

  @Override
  public void update(ProjectInfo entity) {
  }
}