package org.mingi.servlets.chap11.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper<T> {
	/**
	 * resultSet과 오브젝트를 매핑하는 메서드
	 * @param rs resultSet
	 * @return resultSet과 매핑한 오브젝트
	 * @throws SQLException
	 */
    T mapRow(ResultSet rs) throws SQLException;
}
