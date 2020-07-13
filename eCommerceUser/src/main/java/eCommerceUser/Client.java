package eCommerceUser;

public class Client {

	private PurchaseInfo purchaseInfo = new PurchaseInfo();
	private String name;
	private String email;
	private String shippingInfo;
	public PurchaseInfo getPurchaseInfo() {
		return purchaseInfo;
	}
	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(String shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	
}
