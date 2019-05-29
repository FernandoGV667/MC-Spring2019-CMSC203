package com.fgonzalesv;

import java.text.DecimalFormat;

/**
 * Represents an abstract ticket
 * 
 * @author Fernando Gonzales-Vigil
 *
 */
public abstract class Ticket {

  protected String type;
  protected String movieName;
  protected String rating;
  protected int day;
  protected Format format;
  protected int time;
  protected int id;
  protected double price;
  protected final double TAXED_FEE = 1.096;
  protected final int LATE_TIME = 18;

  public Ticket() {
    this.type = "Ticket";
    this.movieName = "";
    this.rating = "";
    this.format = Format.NONE;
    this.day = 1;
    this.time = 8;
    this.price = -1;
  }

  public Ticket(String movieName, String rating, int day, Format format, int time, int id) {
    this.type = "Ticket";
    this.movieName = movieName;
    this.rating = rating;
    this.day = day;
    this.format = format;
    this.time = time;
    this.id = id;
    this.price = -1;
  }

  public abstract double calculateTicketPrice();

  public abstract int getId();

  /**
   * @return the movieName
   */
  public String getMovieName() {
    return movieName;
  }

  /**
   * @param movieName the movieName to set
   */
  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  /**
   * @return the rating
   */
  public String getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(String rating) {
    this.rating = rating;
  }

  /**
   * @return the day
   */
  public int getDay() {
    return day;
  }

  /**
   * @param day the day to set
   */
  public void setDay(int day) {
    this.day = day;
  }

  /**
   * @return the format
   */
  public Format getFormat() {
    return format;
  }

  /**
   * @param format the format to set
   */
  public void setFormat(Format format) {
    this.format = format;
  }

  /**
   * @return the time
   */
  public int getTime() {
    return time;
  }

  /**
   * @param time the time to set
   */
  public void setTime(int time) {
    this.time = time;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("##0.00");

    String typeID = type.toUpperCase();

    if (getId() != -1) {
      typeID += "-" + id;
    }

    String view = "";
    if (format.equals(Format.THREE_D)) {
      view = "3D";
    } else if (format.equals(Format.IMAX)) {
      view = format.toString();
    }
    return typeID + " " + view + " Movie: " + movieName + " Rating: " + rating + " Day: " + day
        + " Time: " + time + " Price: $" + df.format(price);
  }
  
  

}
