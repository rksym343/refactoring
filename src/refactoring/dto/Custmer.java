package refactoring.dto;

import java.util.ArrayList;
import java.util.List;

public class Custmer {
	private String name;
	private List<Rental> rentals;

	public Custmer(String name) {
		super();
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental aRental) {
		this.rentals.add(aRental);
	}

	public String statement() {
		// 대여료와 적립포인트 출력
		double totalAmount = 0; // 대여료
		int frequentRenterPoints = 0; // 적립포인트
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " 고객님의 대여기록\n");

		for (Rental each : rentals) {
			double thisAmount = each.getCharge();
			frequentRenterPoints++;
			if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
			sb.append(String.format("\t%s \t %s%n", each.getMovie().getTitle(), thisAmount));
			totalAmount += thisAmount;
		} // for loop
		sb.append(String.format("누적 대여료 : %s%n적립포인트 : %s%n", totalAmount, frequentRenterPoints));

		return sb.toString();
	}

}
