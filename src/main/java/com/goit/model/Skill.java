package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class Skill implements Identity, IObjectToString {

  private Long id;
  private String industry;
  private String level;

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}