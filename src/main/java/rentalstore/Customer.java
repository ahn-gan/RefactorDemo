package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private Statement statement;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Statement statement) {
        this.name = name;
        this.statement = statement;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
//        statement = new HtmlStatement();
        return statement.statement(rentals, getName());
//        String result = getHeaders();
//        result += getMovieDetail(rentals);
//        result += getTotalAmountRow(getTotalAmount(rentals));
//        result += getRenterPoints(calculateRenterPoints(rentals));
//        return result;
    }

//    private double getTotalAmount(List<Rental> rentals) {
//        double totalAmount = 0;
//        for (Rental each : rentals) {
//            totalAmount += getMovieAmount(each);
//        }
//        return totalAmount;
//    }

    //add footer lines
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

//    private double getMovieAmount(Rental each) {
//        double thisAmount = 0;
//        switch (each.getMovie().getPriceCode()) {
//            case Movie.REGULAR:
//                thisAmount += 2;
//                if (each.getDayRented() > 2) {
//                    thisAmount += (each.getDayRented() - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                thisAmount += each.getDayRented() * 3;
//                break;
//            case Movie.CHILDRENS:
//                thisAmount += 1.5;
//                if (each.getDayRented() > 3) {
//                    thisAmount += (each.getDayRented() - 3) * 1.5;
//                }
//                break;
//        }
//        return thisAmount;
//    }
//
//    private String getRenterPoints(int frequentRenterPoints) {
//        return "On this rental you earned <em>" + frequentRenterPoints + "</em> frequent renter points<p>";
//    }
//
//    private String getTotalAmountRow(double totalAmount) {
//        return "<p>You owe <em>" + totalAmount + "</em><p>\n";
//    }
//
//    private String getMovieDetail(List<Rental> rentals) {
//        String details = "";
//        for(Rental rental: rentals) {
//            details += "\t" + rental.getMovie().getTitle() + "\t" + getMovieAmount(rental) + "<br>\n";
//        }
//        return details;
//    }
//
//    private String getHeaders() {
//        return "<h1>Rental Record for <em>" + getName() + "</em></h1><p>\n";
//    }
//
//    private int calculateRenterPoints(List<Rental> rentals) {
//        int frequentRenterPoints = 0;
//        for (Rental rental : rentals) {
//            frequentRenterPoints += 1;
//            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDayRented() > 1) {
//                frequentRenterPoints++;
//            }
//        }
//        return frequentRenterPoints;
//    }
}
