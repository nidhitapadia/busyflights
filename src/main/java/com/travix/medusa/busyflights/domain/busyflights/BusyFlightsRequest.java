package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * The type Busy flights request.
 */
public class BusyFlightsRequest {

    @NotNull
    @Size(min = 3, max = 3)
    private String origin;
    @NotNull
    @Size(min = 3, max = 3)
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;
    @Min(1)
    @Max(4)
    private int numberOfPassengers;

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
     * Gets number of passengers.
     *
     * @return the number of passengers
     */
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * Sets number of passengers.
     *
     * @param numberOfPassengers the number of passengers
     */
    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BusyFlightsRequest{");
        sb.append("origin='").append(origin).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", numberOfPassengers=").append(numberOfPassengers);
        sb.append('}');
        return sb.toString();
    }
}
