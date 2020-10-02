package org.patricia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.patrixia.DistanceCalculator;

public class DistanceCalculatorTest {
	
	@Test
	public void distanceTestSamePlace() {
		Double lat1 = 0d;
		Double lon1 = 0d;
		Double lat2 = 0d;
		Double lon2 = 0d;
		Double distance = 0d;
		assertEquals(distance, DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2));
	}
	
	@Test
	public void distanceTestAverageDistance() {
		//caballito
		Double lat1 = -34.618344;
		Double lon1 = -58.455023;
		//retiro
		Double lat2 = -34.589705;
		Double lon2 = -58.372883;
		Double distance = 8.164d;
		assertEquals(distance, DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2));
	}

	@Test
	public void distanceTestFarAway() {
		//retiro
		Double lat1 = -34.589705;
		Double lon1 = -58.372883;
		//cordoba
		Double lat2 = -31.376260;
		Double lon2 = -64.181083;
		Double distance = 648.787d;
		assertEquals(distance, DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2));
	}
}
