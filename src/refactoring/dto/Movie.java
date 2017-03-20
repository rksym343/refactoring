package refactoring.dto;

public class Movie {
	public static final int REGULAR = 1;
	public static final int NEW_RELEASE = 2;
	public static final int CHILDRENS = 3;
	
	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		super();
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

}
