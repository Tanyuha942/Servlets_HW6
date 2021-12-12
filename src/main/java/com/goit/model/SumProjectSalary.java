package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class SumProjectSalary implements Identity {

  private String projectName;
  private Double sumSalary;

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public Double getSumSalary() {
    return sumSalary;
  }

  public void setSumSalary(Double sumSalary) {
    this.sumSalary = sumSalary;
  }

  @Override
  public Long getId() {
    return null;
  }

  @Override
  public String toString() {
    return "SumProjectSalary{" +
        "projectName='" + projectName + '\'' +
        ", sumSalary=" + sumSalary +
        '}';
  }
}