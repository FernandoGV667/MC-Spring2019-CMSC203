package com.fgonzalesv;

/**
 * Represents a MoviePass member ticket
 * 
 * @author Fernando Gonzales-Vigil
 *
 */
public class MoviePass extends Ticket {

  private final double ADULT_EARLY_PRICE = 10.5;
  private final double ADULT_LATE_PRICE = 13.5;
  private final double ADULT_IMAX_PRICE = 3;
  private final double ADULT_THREE_D_PRICE = 2.5;

  public MoviePass() {
    super.type = "MoviePass";
  }

  public MoviePass(String movieName, String rating, int day, Format format, int time, int id) {
    super(movieName, rating, day, format, time, id);
    super.type = "MoviePass";
  }

  @Override
  public double calculateTicketPrice() {
    double price = (time < LATE_TIME) ? ADULT_EARLY_PRICE : ADULT_LATE_PRICE;
    if (format.equals(Format.IMAX)) {
      price += ADULT_IMAX_PRICE;
    } else if (format.equals(Format.THREE_D)) {
      price += ADULT_THREE_D_PRICE;
    }
    return price * TAXED_FEE;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return super.toString();
  }

}
