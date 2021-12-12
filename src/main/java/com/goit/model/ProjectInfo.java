package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class ProjectInfo implements Identity {

  private String listProjects;

  public String getListProjects() {
    return listProjects;
  }

  public void setListProjects(String listProjects) {
    this.listProjects = listProjects;
  }

  @Override
  public String toString() {
    return "ProjectInfo{" +
        "listProjects='" + listProjects + '\'' +
        '}';
  }

  @Override
  public Long getId() {
    return null;
  }
}