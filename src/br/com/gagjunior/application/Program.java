package br.com.gagjunior.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.gagjunior.model.entities.Department;
import br.com.gagjunior.model.entities.Seller;

public class Program {

    public static void main(String[] args) {
	
	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate birthDate = LocalDate.parse("25/06/1987", sdf);

	Department department = new Department(1, "Teste");
	Seller seller = new Seller(1, "Gilberto", "gagjunior@hotmail.com", birthDate, 5000.00, department);
	System.out.println(department);
	System.out.println(seller);

    }

}
