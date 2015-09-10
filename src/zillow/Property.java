package zillow;

public class Property {

	private String number = null;
	private String street = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	private int pLow = 0;
	private int pEst = 0;
	private int pHigh = 0;
	private int pRange = 0;
	private int rLow = 0;
	private int rEst = 0;
	private int rHigh = 0;
	private int rRange = 0;
	
	public Property(String number, String street, String city, String state, String zip){		
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	
	public void setValues(int pLow, int pEst, int pHigh, int rLow, int rEst, int rHigh){
		this.pLow = pLow;
		this.pEst = pEst;
		this.pHigh = pHigh;
		this.pRange = pHigh - pLow;
		this.rLow = rLow;
		this.rEst = rEst;
		this.rHigh = rHigh;
		this.rRange = rHigh - rLow;		
	}
	
	public float getPriceRentRatio(){
		float ret = (float) pEst / (float) rEst;
		return ret;
	}

	public String getFullAddress(){
		String addr = number + " " + street + ", " + city + " " + state + ", " + zip;
		return addr;
	}
	public String getNumber() {
		return number;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public int getPLow() {
		return pLow;
	}

	public int getPEst() {
		return pEst;
	}

	public int getPHigh() {
		return pHigh;
	}

	public int getPRange() {
		return pRange;
	}

	public int getRLow() {
		return rLow;
	}
	public int getREst() {
		return rEst;
	}

	public int getRHigh() {
		return rHigh;
	}

	public int getRRange() {
		return rRange;
	}

	
	
}
