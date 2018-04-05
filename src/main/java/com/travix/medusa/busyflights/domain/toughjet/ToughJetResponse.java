package com.travix.medusa.busyflights.domain.toughjet;

import java.time.Instant;

/**
 * The type Tough jet response.
 */
public class ToughJetResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private Instant outboundDateTime;
    private Instant inboundDateTime;

    /**
     * Gets carrier.
     *
     * @return the carrier
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets carrier.
     *
     * @param carrier the carrier
     */
    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    /**
     * Gets base price.
     *
     * @return the base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets base price.
     *
     * @param basePrice the base price
     */
    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets tax.
     *
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * Sets tax.
     *
     * @param tax the tax
     */
    public void setTax(final double tax) {
        this.tax = tax;
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    /**
     * Gets departure airport name.
     *
     * @return the departure airport name
     */
    public String getDepartureAirportName() {
        return departureAirportName;
    }

    /**
     * Sets departure airport name.
     *
     * @param departureAirportName the departure airport name
     */
    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    /**
     * Gets arrival airport name.
     *
     * @return the arrival airport name
     */
    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    /**
     * Sets arrival airport name.
     *
     * @param arrivalAirportName the arrival airport name
     */
    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    /**
     * Gets outbound date time.
     *
     * @return the outbound date time
     */
    public Instant getOutboundDateTime() {
        return outboundDateTime;
    }

    /**
     * Sets outbound date time.
     *
     * @param outboundDateTime the outbound date time
     */
    public void setOutboundDateTime(final Instant outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    /**
     * Gets inbound date time.
     *
     * @return the inbound date time
     */
    public Instant getInboundDateTime() {
        return inboundDateTime;
    }

    /**
     * Sets inbound date time.
     *
     * @param inboundDateTime the inbound date time
     */
    public void setInboundDateTime(final Instant inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ToughJetResponse{");
        sb.append("carrier='").append(carrier).append('\'');
        sb.append(", basePrice=").append(basePrice);
        sb.append(", tax=").append(tax);
        sb.append(", discount=").append(discount);
        sb.append(", departureAirportName='").append(departureAirportName).append('\'');
        sb.append(", arrivalAirportName='").append(arrivalAirportName).append('\'');
        sb.append(", outboundDateTime=").append(outboundDateTime);
        sb.append(", inboundDateTime=").append(inboundDateTime);
        sb.append('}');
        return sb.toString();
    }
}
