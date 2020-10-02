package org.patricia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.patrixia.PriceEstimator;

public class PriceEstimatorTest {

	@Test
	public void priceEstimateTest() {
		Double distance = 100d;
		Double price = 10000d;
		assertEquals(price, PriceEstimator.estimatePrice(distance));
	}
	
}
