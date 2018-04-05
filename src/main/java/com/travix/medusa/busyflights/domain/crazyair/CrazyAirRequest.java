package com.travix.medusa.busyflights.domain.crazyair;

import java.time.LocalDate;

/**
 * The type Crazy air request.
 */
public class CrazyAirRequest {

    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int passengerCount;

    /**
     * Gets origin.
     *
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets origin.
     *
     * @param origin the origin
     */
    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    /**
     * Gets departure date.
     *
     * @return the departure date
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets departure date.
     *
     * @param departureDate the departure date
     */
    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets return date.
     *
     * @return the return date
     */
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Sets return date.
     *
     * @param returnDate the return date
     */
    public void setReturnDate(final LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets passenger count.
     *
     * @return the passenger count
     */
    public int getPassengerCount() {
        return passengerCount;
    }

    /**
     * Sets passenger count.
     *
     * @param passengerCount the passenger count
     */
    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CrazyAirRequest{");
        sb.append("origin='").append(origin).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", passengerCount=").append(passengerCount);
        sb.append('}');
        return sb.toString();
    }
}
