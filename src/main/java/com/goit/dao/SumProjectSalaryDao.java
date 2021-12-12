package com.goit.dao;

import com.goit.model.SumProjectSalary;
import java.sql.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class SumProjectSalaryDao extends AbstractDao<SumProjectSalary> {

  private static final Logger LOGGER = LogManager.getLogger(SumProjectSalaryDao.class);
  private static SumProjectSalaryDao instance;

  private SumProjectSalaryDao() {
  }

  public static SumProjectSalaryDao getInstance() {
    if (instance == null) {
      instance = new SumProjectSalaryDao();
    }
    return instance;
  }

  @Override
  String getTableName() {
    return "sum_salary_developers_of_project";
  }

  @Override
  SumProjectSalary mapToEntity(ResultSet rs) throws SQLException {
    SumProjectSalary salary = new SumProjectSalary();
    salary.setProjectName(rs.getString("project_name"));
    salary.setSumSalary(rs.getDouble("sum_salary"));
    return salary;
  }

  public List<SumProjectSalary> getSumProjectSalary(String projectName) {
    String query = "select * from sum_salary_developers_of_project where project_name = ?";
    List<SumProjectSalary> resultList = new ArrayList<>();
    try {
      ResultSet resultSet = DbHelper.getWithPreparedStatement(
          query, ps -> {
            ps.setString(1, projectName);
          });
      while (resultSet.next()) {
        LOGGER.debug("Record was selected");
        resultList.add(mapToEntity(resultSet));
      }
    } catch (SQLException e) {
      LOGGER.error(e);
    }
    return resultList;
  }

  @Override
  public Optional<SumProjectSalary> create(SumProjectSalary entity) {
    return Optional.empty();
  }

  @Override
  public void update(SumProjectSalary entity) {
  }
}