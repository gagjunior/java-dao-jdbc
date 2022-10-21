package br.com.gagjunior.application;

import br.com.gagjunior.model.dao.DaoFactory;
import br.com.gagjunior.model.dao.SellerDao;
import br.com.gagjunior.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(1);

		System.out.println("TESTE 1 >>>>> findById");
		System.out.println(seller);

	}

}
