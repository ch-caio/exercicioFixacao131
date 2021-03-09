package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class usedProduct extends Product {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	private Date manufactudeDate;
	
	public usedProduct () {
		super ();
	}

	public usedProduct(String name, Double price, Date manufactudeDate) {
		super(name, price);
		this.manufactudeDate = manufactudeDate;
	}

	public Date getManufactudeDate() {
		return manufactudeDate;
	}

	public void setManufactudeDate(Date manufactudeDate) {
		this.manufactudeDate = manufactudeDate;
	}
	
	@Override
	public String priceTag() {
		return getName()
				+ " (used) $ "
				+ String.format("%.2f",getPrice())
				+ " manufacture date: "
				+ sdf.format(manufactudeDate);
	}
	
	
	
}
