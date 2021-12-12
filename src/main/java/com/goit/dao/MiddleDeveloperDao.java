package com.goit.dao;

import com.goit.model.MiddleDeveloper;
import java.sql.*;
import java.util.Optional;

public class MiddleDeveloperDao extends AbstractDao<MiddleDeveloper> {

  @Override
  String getTableName() {
    return "list_of_middle_developers";
  }

  @Override
  MiddleDeveloper mapToEntity(ResultSet rs) throws SQLException {
    MiddleDeveloper middleDeveloper = new MiddleDeveloper();
    middleDeveloper.setDeveloperName(rs.getString("developer_name"));
    return middleDeveloper;
  }

  @Override
  public Optional<MiddleDeveloper> create(MiddleDeveloper entity) {
    return Optional.empty();
  }

  @Override
  public void update(MiddleDeveloper entity) {
  }
}