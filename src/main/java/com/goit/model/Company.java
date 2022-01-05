package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;

public class Company implements Identity, IObjectToString {

  private Long id;
  private String name;

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}