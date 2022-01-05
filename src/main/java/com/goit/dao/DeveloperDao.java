package com.goit.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.logging.log4j.*;
import com.goit.model.Developer;

public class DeveloperDao extends AbstractDao<Developer> {

  private static final Logger LOGGER = LogManager.getLogger(DeveloperDao.class);
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  private static DeveloperDao instance;

  private DeveloperDao() {
  }

  public static DeveloperDao getInstance() {
    if (instance == null) {
      instance = new DeveloperDao();
    }
    return instance;
  }

  @Override
  String getTableName() {
    return "developers";
  }

  @Override
  Developer mapToEntity(ResultSet rs) throws SQLException {

    Developer developer = new Developer();
    developer.setId(rs.getLong("id"));
    developer.setLastName(rs.getString("last_name"));
    developer.setFirstName(rs.getString("first_name"));
    developer.setSurname(rs.getString("surname"));
    developer.setDeveloperAge(rs.getInt("developer_age"));
    developer.setDateOfBirth(format.format(rs.getDate("date_of_birth")));
    developer.setGender(rs.getString("gender"));
    developer.setCompanyId(rs.getLong("company_id"));
    developer.setSalary(rs.getDouble("salary"));
    return developer;
  }

  @Override
  public Optional<Developer> create(Developer developer) {
    String sql = "insert into developers"
        + "(last_name, first_name, surname, developer_age, date_of_birth, gender, company_id, salary)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, developer.getLastName());
      ps.setString(2, developer.getFirstName());
      ps.setString(3, developer.getSurname());
      ps.setInt(4, developer.getDeveloperAge());
      ps.setDate(5, new Date(Date.valueOf(developer.getDateOfBirth()).getTime()));
      ps.setString(6, developer.getGender());
      ps.setLong(7, developer.getCompanyId());
      ps.setDouble(8, developer.getSalary());
    });
    LOGGER.info("Record was created");
    return Optional.empty();
  }

  @Override
  public void update(Developer developer) {
    String sql = "update developers set "
        + "last_name = ?, first_name = ?, surname = ?, developer_age = ?, date_of_birth = ?,"
        + " gender = ?, company_id = ?, salary = ? where id = ?";
    DbHelper.executeWithPreparedStatement(sql, ps -> {
      ps.setString(1, developer.getLastName());
      ps.setString(2, developer.getFirstName());
      ps.setString(3, developer.getSurname());
      ps.setInt(4, developer.getDeveloperAge());
      ps.setDate(5, new Date(Date.valueOf(developer.getDateOfBirth()).getTime()));
      ps.setString(6, developer.getGender());
      ps.setLong(7, developer.getCompanyId());
      ps.setDouble(8, developer.getSalary());
      ps.setLong(9, developer.getId());
    });
    LOGGER.info("Record was updated");
  }

  public List<Developer> getProjectDevelopers(String name) {
    List<Developer> resultList = new ArrayList<>();
    String sql = "select d.*\n" +
            "from developers d\n" +
            "join developer_project dp on dp.developer_id = d.id\n" +
            "join projects p on p.id = dp.project_id\n" +
            "where p.project_name = ? ";
    try {
      ResultSet resultSet = DbHelper.getWithPreparedStatement(
              sql, ps -> {
                ps.setString(1, name);
              });
      while (resultSet.next()) {
        resultList.add(mapToEntity(resultSet));
      }
    } catch (SQLException e) {
      LOGGER.error("Get projectDevelopers exception", e);
    }
    return resultList;
  }

  public List<Developer> getDevelopersOfIndustry(String name) {
    List<Developer> resultList = new ArrayList<>();
    String sql = "select d.* " +
            " from developers d " +
            "join developer_skill ds on d.id = ds.developer_id " +
            "join skills s on s.id = ds.skill_id " +
            "where s.industry = ? ";
    try {
      ResultSet resultSet = DbHelper.getWithPreparedStatement(
              sql, ps -> {
                ps.setString(1, name);
              });
      while (resultSet.next()) {
        resultList.add(mapToEntity(resultSet));
      }
    } catch (SQLException e) {
      LOGGER.error("Get developersOfIndustry exception", e);
    }
    return resultList;
  }

  public List<Developer> getDevelopersOfLevel(String name) {
    List<Developer> resultList = new ArrayList<>();
    String sql = "select d.* " +
            " from developers d " +
            "join developer_skill ds on d.id = ds.developer_id " +
            "join skills s on s.id = ds.skill_id " +
            "where s.level_skills = ? ";
    try {
      ResultSet resultSet = DbHelper.getWithPreparedStatement(
              sql, ps -> {
                ps.setString(1, name);
              });
      while (resultSet.next()) {
        resultList.add(mapToEntity(resultSet));
      }
    } catch (SQLException e) {
      LOGGER.error("Get developersOfLevel exception", e);
    }
    return resultList;
  }
}