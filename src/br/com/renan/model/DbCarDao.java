package br.com.renan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.com.renan.model.db.DBUtil;

public class DbCarDao implements CarDao {

	private DataSource dataSource;

	public DbCarDao() {
		this.dataSource = DBUtil.getDataSource();
	}

	@Override
	public List<Car> getAll() {

		List<Car> cars = new ArrayList<Car>();

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from carro");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setId(rs.getInt(1));
				car.setBrand(rs.getString("marca"));
				car.setModel(rs.getString("modelo"));
				car.setWebsite(rs.getString("website"));
				cars.add(car);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cars;
	}

	@Override
	public Car getById(int id) {
		Connection conn;
		Car car = new Car();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from carro where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				car.setId(rs.getInt(1));
				car.setBrand(rs.getString("marca"));
				car.setModel(rs.getString("modelo"));
				car.setWebsite(rs.getString("website"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return car;
	}

	@Override
	public boolean add(Car c) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into carro(marca,modelo,website) values(?,?,?)");
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getModel());
			ps.setString(3, c.getWebsite());
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return true;
	}

	@Override
	public boolean update(Car c) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update carro set marca = ?, modelo = ?, website = ? where id = ?");
			ps.setString(1, c.getBrand());
			ps.setString(2, c.getModel());
			ps.setString(3, c.getWebsite());
			ps.setInt(4, c.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public boolean delete(Car c) {
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("delete from carro where id = ?");
			ps.setInt(1, c.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
