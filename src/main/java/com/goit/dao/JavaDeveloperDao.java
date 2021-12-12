package com.goit.dao;

import com.goit.model.JavaDeveloper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JavaDeveloperDao extends AbstractDao<JavaDeveloper> {

  @Override
  String getTableName() {
    return "list_of_java_developers";
  }

  @Override
  JavaDeveloper mapToEntity(ResultSet rs) throws SQLException {
    JavaDeveloper javaDeveloper = new JavaDeveloper();
    javaDeveloper.setDeveloperName(rs.getString("developer_name"));
    return javaDeveloper;
  }

  @Override
  public Optional<JavaDeveloper> create(JavaDeveloper entity) {
    return Optional.empty();
  }

  @Override
  public void update(JavaDeveloper entity) {

  }
}
