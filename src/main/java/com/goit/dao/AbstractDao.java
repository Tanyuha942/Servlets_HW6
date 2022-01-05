package com.goit.dao;

import com.goit.dao.dao_tables_interfaces.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

abstract public class AbstractDao<T extends Identity> implements Dao<T> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);

    abstract String getTableName();
    abstract T mapToEntity(ResultSet rs) throws SQLException;

    @Override
    public void delete(T entity) {
        String sql = String.format("delete from %s where id = ?", getTableName());
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
        });
        LOGGER.debug("Deleted record from " + getTableName());
    }

    @Override
    public Optional<T> get(Long id) {
        String query = String.format("select * from %s where id = ?", getTableName());
        try {
            ResultSet resultSet = DbHelper.getWithPreparedStatement(
                    query, ps -> {
                        ps.setLong(1, id);
                    });
            if (resultSet.next()) {
                LOGGER.debug("Record was selected");
                return Optional.of(mapToEntity(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        List<T> resultList = new ArrayList<>();
        String query = String.format("select * from %s", getTableName() + " Order by 1");
        try {
            ResultSet resultSet = DbHelper.getWithPreparedStatement(
                    query, ps -> {
                    });
            while (resultSet.next()) {
                resultList.add(mapToEntity(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error("Get all method exception", e);
        }
        return resultList;
    }
}
