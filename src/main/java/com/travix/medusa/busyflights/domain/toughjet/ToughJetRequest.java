package com.travix.medusa.busyflights.domain.toughjet;

import java.time.LocalDate;

/**
 * The type Tough jet request.
 */
public class ToughJetRequest {

    private String from;
    private String to;
    private LocalDate outboundDate;
    private LocalDate inboundDate;
    private int numberOfAdults;

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(final String from) {
        this.from = from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(final String to) {
        this.to = to;
    }

    /**
     * Gets outbound date.
     *
     * @return the outbound date
     */
    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    /**
     * Sets outbound date.
     *
     * @param outboundDate the outbound date
     */
    public void setOutboundDate(final LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    /**
     * Gets inbound date.
     *
     * @return the inbound date
     */
    public LocalDate getInboundDate() {
        return inboundDate;
    }

    /**
     * Sets inbound date.
     *
     * @param inboundDate the inbound date
     */
    public void setInboundDate(final LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    /**
     * Gets number of adults.
     *
     * @return the number of adults
     */
    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    /**
     * Sets number of adults.
     *
     * @param numberOfAdults the number of adults
     */
    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ToughJetRequest{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", outboundDate=").append(outboundDate);
        sb.append(", inboundDate=").append(inboundDate);
        sb.append(", numberOfAdults=").append(numberOfAdults);
        sb.append('}');
        return sb.toString();
    }
}
