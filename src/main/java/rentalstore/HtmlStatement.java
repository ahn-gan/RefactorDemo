package rentalstore;

import java.util.List;

public class HtmlStatement extends Statement {
    @Override
    protected String getRenterPoints(double frequentRenterPoints) {
        return "On this rental you earned <em>" + frequentRenterPoints + "</em> frequent renter points<p>";
    }

    @Override
    protected String getTotalAmountRow(double totalAmount) {
        return "<p>You owe <em>" + totalAmount + "</em><p>\n";
    }

    @Override
    protected String getMovieDetail(List<Rental> rentals) {
        String details = "";
        for(Rental rental: rentals) {
            details += "\t" + rental.getMovie().getTitle() + "\t" + getMovieAmount(rental) + "<br>\n";
        }
        return details;
    }

    @Override
    public String getHeaders(String name) {
        return "<h1>Rental Record for <em>" + name + "</em></h1><p>\n";
    }
}
