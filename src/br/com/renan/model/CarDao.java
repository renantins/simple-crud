package br.com.renan.model;

import java.util.List;

public interface CarDao {

	List<Car> getAll() throws Exception;

	Car getById(int id) throws Exception;

	boolean add(Car c) throws Exception;

	boolean update(Car c) throws Exception;

	boolean delete(Car c) throws Exception;
}
