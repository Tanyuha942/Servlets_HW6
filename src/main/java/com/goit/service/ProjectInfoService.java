package com.goit.service;

import com.goit.dao.ProjectInfoDao;
import com.goit.model.ProjectInfo;
import java.util.List;
import org.apache.logging.log4j.*;

public class ProjectInfoService {

  private static final Logger LOGGER = LogManager.getLogger(ProjectInfoService.class);
  ProjectInfoDao projectInfoDao = new ProjectInfoDao();

  public List<ProjectInfo> getAll() {
    return projectInfoDao.getAll();
  }
}