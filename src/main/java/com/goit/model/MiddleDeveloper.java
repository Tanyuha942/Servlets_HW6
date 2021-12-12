package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class MiddleDeveloper implements Identity {

  private String developerName;

  public String getDeveloperName() {
    return developerName;
  }

  public void setDeveloperName(String developerName) {
    this.developerName = developerName;
  }

  @Override
  public String toString() {
    return "MiddleDeveloper{" +
        "developerName='" + developerName + '\'' +
        '}';
  }

  @Override
  public Long getId() {
    return null;
  }
}