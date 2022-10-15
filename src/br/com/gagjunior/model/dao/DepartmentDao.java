package br.com.gagjunior.model.dao;

import java.util.List;

import br.com.gagjunior.model.entities.Department;

public interface DepartmentDao {
	void insert(Department department);
	void update(Department department);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
