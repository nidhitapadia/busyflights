package com.travix.medusa.busyflights.domain.crazyair;

import java.time.LocalDateTime;

/**
 * The type Crazy air response.
 */
public class CrazyAirResponse {

    private String airline;
    private double price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;

    /**
     * Gets airline.
     *
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Sets airline.
     *
     * @param airline the airline
     */
    public void setAirline(final String airline) {
        this.airline = airline;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(final double price) {
        this.price = price;
    }

    /**
     * Gets cabinclass.
     *
     * @return the cabinclass
     */
    public String getCabinclass() {
        return cabinclass;
    }

    /**
     * Sets cabinclass.
     *
     * @param cabinclass the cabinclass
     */
    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    /**
     * Gets departure airport code.
     *
     * @return the departure airport code
     */
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    /**
     * Sets departure airport code.
     *
     * @param departureAirportCode the departure airport code
     */
    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    /**
     * Gets destination airport code.
     *
     * @return the destination airport code
     */
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * Sets destination airport code.
     *
     * @param destinationAirportCode the destination airport code
     */
    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    /**
     * Gets departure date.
     *
     * @return the departure date
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets departure date.
     *
     * @param departureDate the departure date
     */
    public void setDepartureDate(final LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets arrival date.
     *
     * @return the arrival date
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets arrival date.
     *
     * @param arrivalDate the arrival date
     */
    public void setArrivalDate(final LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CrazyAirResponse{");
        sb.append("airline='").append(airline).append('\'');
        sb.append(", price=").append(price);
        sb.append(", cabinclass='").append(cabinclass).append('\'');
        sb.append(", departureAirportCode='").append(departureAirportCode).append('\'');
        sb.append(", destinationAirportCode='").append(destinationAirportCode).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append('}');
        return sb.toString();
    }
}
