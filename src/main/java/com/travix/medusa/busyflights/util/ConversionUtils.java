package com.travix.medusa.busyflights.util;

import java.text.DecimalFormat;

/**
 * The type Conversion utils.
 */
public class ConversionUtils {
    /**
     * Convert double value to decimal value with two digit precision string.
     *
     * @param value the value
     * @return the converted string
     */
    public static String toDecimalValueWithTwoDigitPrecision(double value) {
        return new DecimalFormat("#0.00").format(value);
    }

    private ConversionUtils() {
        //private constructor
    }
}
