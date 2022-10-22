package br.com.gagjunior.application;

import java.util.List;

import br.com.gagjunior.model.dao.DaoFactory;
import br.com.gagjunior.model.dao.SellerDao;
import br.com.gagjunior.model.entities.Department;
import br.com.gagjunior.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(1);

		System.out.println("\nTESTE 1 >>>>> Seller: findById");
		System.out.println(seller);

		System.out.println("\nTESTE 2 >>>>> Seller: findByDepartment");
		Department dep = new Department(1, null);
		List<Seller> sellerList = sellerDao.findByDepartment(dep);		
		sellerList.forEach(x -> System.out.println(x));
		
		System.out.println("\nTESTE 3 >>>>> Seller: findAll");
		sellerList = sellerDao.findAll();
		
		sellerList.forEach(x -> System.out.println(x));
		
	}

}
