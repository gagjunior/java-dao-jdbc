package br.com.gagjunior.model.dao;

import br.com.gagjunior.model.entities.Department;

public interface DepartmentDao {
	void insert(Department department);
	void update(Department department);
	void deleteById(Integer id);
}
