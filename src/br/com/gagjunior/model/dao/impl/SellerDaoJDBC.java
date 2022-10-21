package br.com.gagjunior.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	    st = conn.prepareStatement("select s.*, d.Name as DepName " + "from seller s inner join department d "
		    + "on s.DepartmentId = d.Id where s.Id = ?");
	    st.setInt(1, id);
	    rs = st.executeQuery();
	    if (rs.next()) {
		Department dep = instantiateDepartment(rs);
		Seller seller = instantiateSeller(rs, dep);
		return seller;
	    }
	    return null;

	} catch (SQLException e) {
	    throw new DbException(e.getMessage());
	} finally {
	    DB.closeStatement(st);
	    DB.closeResultSet(rs);
	}
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
	Seller seller = new Seller();
	seller.setId(rs.getInt("Id"));
	seller.setName(rs.getString("Name"));
	seller.setEmail(rs.getString("Email"));
	seller.setBirthDate(rs.getDate("BirthDate").toLocalDate());
	seller.setBaseSalary(rs.getDouble("BaseSalary"));
	seller.setDepartment(dep);
	return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
	Department dep = new Department();
	dep.setId(rs.getInt("DepartmentId"));
	dep.setName(rs.getString("DepName"));
	return dep;
    }

    @Override
    public List<Seller> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
	PreparedStatement st = null;
	ResultSet rs = null;
	try {
	    st = conn.prepareStatement("select s.*,	d.Name as DepName " + "from seller s inner join department d "
		    + "on s.DepartmentId = d.Id where d.Id = ? order by s.Name");
	    st.setInt(1, department.getId());

	    rs = st.executeQuery();

	    List<Seller> sellerList = new ArrayList<>();
	    Map<Integer, Department> mapDepartment = new HashMap<>();

	    while (rs.next()) {

		Department dep = mapDepartment.get(rs.getInt("DepartmentId"));

		if (dep == null) {
		    dep = instantiateDepartment(rs);
		    mapDepartment.put(rs.getInt("DepartmentId"), dep);
		}

		Seller seller = instantiateSeller(rs, dep);
		sellerList.add(seller);

	    }
	    return sellerList;

	} catch (SQLException e) {
	    throw new DbException(e.getMessage());
	} finally {
	    DB.closeStatement(st);
	    DB.closeResultSet(rs);
	}
    }

}
