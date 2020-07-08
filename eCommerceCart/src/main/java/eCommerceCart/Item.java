package eCommerceCart;

public class Item {

	private long iD;
	
	private String title;
	
	private String description;
	
	private double unitPrice;
	
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getiD() {
		return iD;
	}
	public void setiD(long iD) {
		this.iD = iD;
	}

}
