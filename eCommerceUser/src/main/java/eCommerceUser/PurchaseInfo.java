package eCommerceUser;

public class PurchaseInfo {

	private String cCNumber;
	private int expirationMonth;
	private int expirationYear;
	private int cVV;
	
	public String getcCNumber() {
		return cCNumber;
	}
	public void setcCNumber(String cCNumber) {
		this.cCNumber = cCNumber;
	}
	public int getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public int getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}
	public int getcVV() {
		return cVV;
	}
	public void setcVV(int cVV) {
		this.cVV = cVV;
	}
	public Boolean validatePayment() {
		if(cCNumber.charAt(0) == '4' || cCNumber.charAt(0) == '5') {
			return true;
		}
		return false;
	}
	
}
