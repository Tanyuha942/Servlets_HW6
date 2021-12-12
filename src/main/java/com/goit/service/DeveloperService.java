package com.goit.service;

import com.goit.dao.DeveloperDao;
import com.goit.model.Developer;
import java.util.*;
import org.apache.logging.log4j.*;

public class DeveloperService {

  private static final Logger LOGGER = LogManager.getLogger(DeveloperService.class);
  DeveloperDao developerDao = new DeveloperDao();

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
}