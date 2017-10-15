package model;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;

public class Ticket implements Comparable<Ticket> {

    private double price;

    public Ticket(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Ticket other) {
        return Double.compare(price, other.price);
    }

    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(price);
    }
}
