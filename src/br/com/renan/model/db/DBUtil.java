package br.com.renan.model.db;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBUtil {

	private static DataSource dataSource;

	public DBUtil() {

	}

	public static DataSource getDataSource() {
		if (dataSource != null) {
			return dataSource;
		} else {
			MysqlDataSource mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setUrl("jdbc:mysql://localhost/javateste");
			mysqlDataSource.setUser("root");
			mysqlDataSource.setPassword("");
			dataSource = mysqlDataSource;
		}
		return dataSource;
	}

}
