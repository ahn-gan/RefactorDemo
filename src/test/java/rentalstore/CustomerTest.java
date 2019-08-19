package rentalstore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void should_return_statement_result_when_rent_a_regular_movie_for_2_days() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("THe", Movie.REGULAR), 2));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\tTHe\t2.0<br>\n" +
                "<p>You owe <em>2.0</em><p>\n" +
                "On this rental you earned <em>1.0</em> frequent renter points<p>", statement);
    }

    @Test
    public void should_return_statement_result_when_rent_a_regular_movie_for_3_days() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("THe", Movie.REGULAR), 3));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\tTHe\t3.5<br>\n" +
                "<p>You owe <em>3.5</em><p>\n" +
                "On this rental you earned <em>1.0</em> frequent renter points<p>", statement);
    }


    @Test
    public void should_return_statement_result_when_rent_a_new_release_movie_for_3_days() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("hehehe", Movie.NEW_RELEASE), 3));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\thehehe\t9.0<br>\n" +
                "<p>You owe <em>9.0</em><p>\n" +
                "On this rental you earned <em>2.0</em> frequent renter points<p>", statement);
    }

    @Test
    public void should_return_statement_result_when_rent_a_children_movie_for_3_days() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("hehehe", Movie.CHILDRENS), 3));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\thehehe\t1.5<br>\n" +
                "<p>You owe <em>1.5</em><p>\n" +
                "On this rental you earned <em>1.0</em> frequent renter points<p>", statement);
    }

    @Test
    public void should_return_statement_result_when_rent_a_children_movie_for_4_days() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("hehehe", Movie.CHILDRENS), 4));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\thehehe\t3.0<br>\n" +
                "<p>You owe <em>3.0</em><p>\n" +
                "On this rental you earned <em>1.0</em> frequent renter points<p>", statement);
    }

    @Test
    public void should_return_statement_result_with_all_types_when_customer_rent_3_kinds_of_movies() {
        Customer customer = new Customer("Akin", new HtmlStatement());
        customer.addRental(new Rental(new Movie("hehehe", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("THe", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Ohn", Movie.CHILDRENS), 2));

        String statement = customer.statement();

        Assert.assertEquals("<h1>Rental Record for <em>Akin</em></h1><p>\n" +
                "\thehehe\t9.0<br>\n" +
                "\tTHe\t2.0<br>\n" +
                "\tOhn\t1.5<br>\n" +
                "<p>You owe <em>12.5</em><p>\n" +
                "On this rental you earned <em>4.0</em> frequent renter points<p>", statement);
    }
}