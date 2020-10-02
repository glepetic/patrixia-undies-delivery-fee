package org.patrixia;

public class PriceEstimator {

    private static final Double PRICE_PER_KM = 100d;

    private PriceEstimator() {}

    public static Double estimatePrice(Double kms) {
        return kms*PRICE_PER_KM;
    }

}
