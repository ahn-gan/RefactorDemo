package rentalstore;

import java.util.List;

public abstract class Statement {

    public String statement(List<Rental> rentals, String name) {
        String result = getHeaders(name);
        result += getMovieDetail(rentals);
        result += getTotalAmountRow(getTotalAmount(rentals));
        result += getRenterPoints(calculateRenterPoints(rentals));
        return result;
    }

    protected abstract String getRenterPoints(double calculateRenterPoints);

    protected abstract String getTotalAmountRow(double totalAmount);

    protected abstract String getMovieDetail(List<Rental> rentals);

    public abstract String getHeaders(String name);

//    public abstract double getTotalAmount(List<Rental> rentals);

//    public abstract int calculateRenterPoints(List<Rental> rentals);

    public double getTotalAmount(List<Rental> rentals) {
//        return rentals.stream().mapToDouble(Rental::)
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += getMovieAmount(each);
        }
        return totalAmount;
    }

    public double getMovieAmount(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDayRented() > 2) {
                    thisAmount += (each.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDayRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDayRented() > 3) {
                    thisAmount += (each.getDayRented() - 3) * 1.5;
                }
                break;
            case Movie.LITERARY_FILM:
                thisAmount += 6;
                break;
        }
        return thisAmount;
    }

    public double calculateRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            if (rental.getMovie().getPriceCode() != Movie.LITERARY_FILM) {
                frequentRenterPoints += 1;
                if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1) {
                    frequentRenterPoints++;
                }
            } else {
                frequentRenterPoints += 1.5;
            }

        }
        return frequentRenterPoints;
    }
}
