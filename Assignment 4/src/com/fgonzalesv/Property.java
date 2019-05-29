package com.fgonzalesv;

public class Property {

  private String city;
  private String owner;
  private String propertyName;
  private double rentAmount;
  private Plot plot;

  public Property() {
    this.city = "";
    this.owner = "";
    this.propertyName = "";
    this.rentAmount = 0;
    this.plot = new Plot();
  }

  public Property(Property p) {
    this.city = p.city;
    this.owner = p.owner;
    this.propertyName = p.propertyName;
    this.rentAmount = p.rentAmount;
    this.plot = new Plot(p.plot);
  }

  public Property(String propertyName, String city, double rentAmount, String owner) {
    this.city = city;
    this.owner = owner;
    this.propertyName = propertyName;
    this.rentAmount = rentAmount;
    this.plot = new Plot();
  }

  public Property(String propertyName, String city, double rentAmount, String owner, int x, int y,
      int width, int depth) {
    this.city = city;
    this.owner = owner;
    this.propertyName = propertyName;
    this.rentAmount = rentAmount;
    this.plot = new Plot(x, y, width, depth);
  }


  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the owner
   */
  public String getOwner() {
    return owner;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(String owner) {
    this.owner = owner;
  }

  /**
   * @return the propertyName
   */
  public String getPropertyName() {
    return propertyName;
  }

  /**
   * @param propertyName the propertyName to set
   */
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  /**
   * @return the rentAmount
   */
  public double getRentAmount() {
    return rentAmount;
  }

  /**
   * @param rentAmount the rentAmount to set
   */
  public void setRentAmount(double rentAmount) {
    this.rentAmount = rentAmount;
  }
  

  /**
   * @return the plot
   */
  public Plot getPlot() {
    return plot;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Property Name: " + propertyName + "\nLocated in " + city + "\nBelonging to " + owner
        + "\nRent Amount: " + rentAmount;
  }


}
