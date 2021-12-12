package com.goit.service;

import com.goit.dao.SumProjectSalaryDao;
import com.goit.model.Company;
import com.goit.model.SumProjectSalary;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.*;

public class SumProjectSalaryService {

  private static SumProjectSalaryService instance;
  private static final Logger LOGGER = LogManager.getLogger(SumProjectSalaryService.class);
  private static final SumProjectSalaryDao sumProjectSalaryDao = SumProjectSalaryDao.getInstance();

  private SumProjectSalaryService() {
  }

  public static SumProjectSalaryService getInstance() {
    if (instance == null) {
      instance = new SumProjectSalaryService();
    }
    return instance;
  }

  public List<SumProjectSalary> getAll() {
    return sumProjectSalaryDao.getAll();
  }

  public List<SumProjectSalary> getSumProjectSalary(String projectName) {
    return sumProjectSalaryDao.getSumProjectSalary(projectName);
  }
}