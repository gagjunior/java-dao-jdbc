package br.com.gagjunior.model.dao;

import java.util.List;

import br.com.gagjunior.model.entities.Department;
import br.com.gagjunior.model.entities.Seller;

public interface SellerDao {
	void insert(Seller department);
	void update(Seller department);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
