package com.goit.service;

import com.goit.dao.DeveloperDao;
import com.goit.model.Developer;

import java.sql.SQLException;
import java.util.*;
import org.apache.logging.log4j.*;

public class DeveloperService {

  private static final Logger LOGGER = LogManager.getLogger(DeveloperService.class);
  private static final DeveloperDao developerDao = DeveloperDao.getInstance();
  private static DeveloperService instance;

  private DeveloperService() {
  }

  public static DeveloperService getInstance() {
    if (instance == null) {
      instance = new DeveloperService();
    }
    return instance;
  }

  public List<Developer> getAll() {
    return developerDao.getAll();
  }

  public Optional<Developer> get(long id) {
    return developerDao.get(id);
  }

  public void update(Developer developer) {
    developerDao.update(developer);
  }

  public void create(Developer developer) {
    developerDao.create(developer);
  }

  public void delete(Developer developer) {
    developerDao.delete(developer);
  }

  public List<Developer> getProjectDevelopers(String projectName) throws SQLException {
    return developerDao.getProjectDevelopers(projectName);
  }

  public List<Developer> getDevelopersOfIndustry(String name) {
    return developerDao.getDevelopersOfIndustry(name);
  }

  public List<Developer> getDevelopersOfLevel(String name) {
    return developerDao.getDevelopersOfLevel(name);
  }
}