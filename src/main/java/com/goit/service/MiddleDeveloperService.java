package com.goit.service;

import com.goit.dao.MiddleDeveloperDao;
import com.goit.model.MiddleDeveloper;
import java.util.List;
import org.apache.logging.log4j.*;

public class MiddleDeveloperService {

  private static final Logger LOGGER = LogManager.getLogger(MiddleDeveloperService.class);
  MiddleDeveloperDao middleDeveloperDao = new MiddleDeveloperDao();

  public List<MiddleDeveloper> getAll() {
    return middleDeveloperDao.getAll();
  }
}