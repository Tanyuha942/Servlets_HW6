package com.goit.model;

import com.goit.dao.dao_tables_interfaces.Identity;
import java.util.Date;

public class Project implements Identity, IObjectToString {

  private Long id;
  private String name;
  private String created;
  private Double cost;

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

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return jsonObjectString().toJson(this);
  }
}