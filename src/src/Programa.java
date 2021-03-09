package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.usedProduct;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner (System.in);
	Locale.setDefault(Locale.US);
	
	List <Product> list = new ArrayList<>(); 
	
	System.out.print("Enter the number of products: ");
	int n = sc.nextInt();
	
	
	for (int i=1; i <=n; i++) {
		System.out.println("Product #"+i+" data:");
		System.out.println("Common, used or imported (c/u/i)?");
		char r = sc.next(). charAt(0);
		System.out.print("Name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Price: ");
		Double price = sc.nextDouble();
		
		if (r == 'c') {
			list.add(new Product(name,price));
		}
		
		if (r == 'i') {
			System.out.print("Customs fee(taxa alfandega): ");
			Double customFee = sc.nextDouble();
			list.add(new ImportedProduct(name,price,customFee));
		} if (r == 'u') {
			System.out.println("Manufacture date (DD/MM/YYYY): ");
			Date manuFacture = sdf.parse(sc.next());
			list.add(new usedProduct(name, price, manuFacture));
		}
	}
	System.out.println();
	System.out.println("PRICE TAGS: ");
	for (Product prod : list) {
		System.out.println(prod.priceTag());
	}
	sc.close();
	}
}
