package com.travix.medusa.busyflights.domain.busyflights;

import java.time.ZonedDateTime;

public class BusyFlightsResponse {

    private String airline;
    private Supplier supplier;
    private String fare;
    private String departureAirportCode;
    private String destinationAirportCode;
    private ZonedDateTime departureDate;
    private ZonedDateTime arrivalDate;

    public BusyFlightsResponse(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Getter for property 'airline'.
     *
     * @return Value for property 'airline'.
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Setter for property 'airline'.
     *
     * @param airline Value to set for property 'airline'.
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * Getter for property 'supplier'.
     *
     * @return Value for property 'supplier'.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Getter for property 'fare'.
     *
     * @return Value for property 'fare'.
     */
    public String getFare() {
        return fare;
    }

    /**
     * Setter for property 'fare'.
     *
     * @param fare Value to set for property 'fare'.
     */
    public void setFare(String fare) {
        this.fare = fare;
    }

    /**
     * Getter for property 'departureAirportCode'.
     *
     * @return Value for property 'departureAirportCode'.
     */
    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    /**
     * Setter for property 'departureAirportCode'.
     *
     * @param departureAirportCode Value to set for property 'departureAirportCode'.
     */
    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    /**
     * Getter for property 'destinationAirportCode'.
     *
     * @return Value for property 'destinationAirportCode'.
     */
    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    /**
     * Setter for property 'destinationAirportCode'.
     *
     * @param destinationAirportCode Value to set for property 'destinationAirportCode'.
     */
    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    /**
     * Getter for property 'departureDate'.
     *
     * @return Value for property 'departureDate'.
     */
    public ZonedDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Setter for property 'departureDate'.
     *
     * @param departureDate Value to set for property 'departureDate'.
     */
    public void setDepartureDate(ZonedDateTime departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Getter for property 'arrivalDate'.
     *
     * @return Value for property 'arrivalDate'.
     */
    public ZonedDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Setter for property 'arrivalDate'.
     *
     * @param arrivalDate Value to set for property 'arrivalDate'.
     */
    public void setArrivalDate(ZonedDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BusyFlightsResponse{");
        sb.append("airline='").append(airline).append('\'');
        sb.append(", supplier='").append(supplier).append('\'');
        sb.append(", fare='").append(fare).append('\'');
        sb.append(", departureAirportCode='").append(departureAirportCode).append('\'');
        sb.append(", destinationAirportCode='").append(destinationAirportCode).append('\'');
        sb.append(", departureDate=").append(departureDate);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append('}');
        return sb.toString();
    }
}
