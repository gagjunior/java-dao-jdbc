package br.com.gagjunior.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.gagjunior.db.DB;
import br.com.gagjunior.db.DbException;
import br.com.gagjunior.model.dao.SellerDao;
import br.com.gagjunior.model.entities.Department;
import br.com.gagjunior.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;		
	}

	@Override
	public void insert(Seller department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select s.*, d.name as dep_name "
					+ "from seller s inner join department d on s.department_id = d.id "
					+ "where s.id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = new Department();	
				dep.setId(rs.getInt("department_id"));
				dep.setName(rs.getString("dep_name"));
				
				Seller seller = new Seller();
				seller.setId(rs.getInt("id"));
				seller.setName(rs.getString("name"));
				seller.setEmail(rs.getString("email"));
				seller.setBirthDate(rs.getDate("birth_date").toLocalDate());
				seller.setBaseSalary(rs.getDouble("base_salary"));
				seller.setDepartment(dep);
				return seller;
			}
			return null;
			
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
