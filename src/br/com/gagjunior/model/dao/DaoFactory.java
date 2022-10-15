package br.com.gagjunior.model.dao;

import br.com.gagjunior.db.DB;
import br.com.gagjunior.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());		
	}
}
