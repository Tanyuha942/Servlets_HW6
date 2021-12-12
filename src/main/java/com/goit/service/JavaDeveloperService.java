package com.goit.service;

import com.goit.dao.JavaDeveloperDao;
import com.goit.model.JavaDeveloper;
import java.util.*;
import org.apache.logging.log4j.*;

public class JavaDeveloperService {

  private static final Logger LOGGER = LogManager.getLogger(JavaDeveloperService.class);
  JavaDeveloperDao javaDeveloperDao = new JavaDeveloperDao();

  public List<JavaDeveloper> getAll() {
    return javaDeveloperDao.getAll();
  }
}