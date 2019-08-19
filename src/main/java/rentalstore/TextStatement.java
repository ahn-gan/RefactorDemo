package rentalstore;

import java.util.List;

public class TextStatement extends Statement {

    @Override
    protected String getRenterPoints(double frequentRenterPoints) {
        return "On this rental you earned " + frequentRenterPoints + " frequent renter points<p>";
    }

    @Override
    protected String getTotalAmountRow(double totalAmount) {
        return "You owe " + totalAmount + "\n";
    }

    @Override
    protected String getMovieDetail(List<Rental> rentals) {
        String details = "";
        for(Rental rental: rentals) {
            details += "\t" + rental.getMovie().getTitle() + "\t" + getMovieAmount(rental) + "\n";
        }
        return details;
    }

    @Override
    public String getHeaders(String name) {
        return "Rental Record for <em>" + name + "\n";
    }


}
