package refactoring.dto;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		super();
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getCharge() {
		// 비디오물당 대여료
		// 1. 일반물(2일) 2000원, 일일 초과 당1500, 적립 1
		// 2. 일반물(3일) 1500원, 일일 초과 당 1500, 적립 1
		// 3. 최신물(1일) 3000원, 일일 초과 당 3000, 적립 1+1
		double result = 0; 

		switch (movie.getPriceCode()) {
		case Movie.REGULAR:
			result = 2000;
			if (daysRented > 2) {
				result += (daysRented - 2) * 1500;
			}
			break;
		case Movie.NEW_RELEASE:
			result = (daysRented * 3000);
			break;
		case Movie.CHILDRENS:
			result = 1500;
			if (daysRented > 3) {
				result += (daysRented - 3) * 1500;
			}
			break;

		}
		return result;
	}

}
