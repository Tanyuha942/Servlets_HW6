package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class ProjectDeveloper implements Identity {

  private String projectName;
  private String developer;

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public String getDeveloper() {
    return developer;
  }

  public void setDeveloper(String developer) {
    this.developer = developer;
  }

  @Override
  public Long getId() {
    return null;
  }

  @Override
  public String toString() {
    return "ProjectDeveloper{" +
        "projectName='" + projectName + '\'' +
        ", developer='" + developer + '\'' +
        '}';
  }
}