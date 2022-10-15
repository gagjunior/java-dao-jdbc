package br.com.gagjunior.application;

import br.com.gagjunior.model.dao.DaoFactory;
import br.com.gagjunior.model.dao.SellerDao;
import br.com.gagjunior.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(13);

		System.out.println(seller);

	}

}
