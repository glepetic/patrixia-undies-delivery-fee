package org.patricia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.patrixia.DistanceCalculator;
import org.patrixia.PriceEstimator;

public class ImplementationTest {

	String place1;
	String place2;
	Double distance;
	Double price;
	
	@Test
	public void priceFromCaballitoToRetiro() {
		
		Double priceActual = 0d;
		Double distanceActual = 0d;
		
		Double lat1 = 0d;
		Double lon1 = 0d;
		Double lat2 = 0d;
		Double lon2 = 0d;
		Double distance = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
		price = PriceEstimator.estimatePrice(distance);
		
		assertEquals(distanceActual, distance);
		assertEquals(priceActual, price);
		
	}
	
	
	@Test
	public void priceFromCampusToMedrano() {
		
		Double priceActual = 0d;
		Double distanceActual = 0d;
		
		Double lat1 = 0d;
		Double lon1 = 0d;
		Double lat2 = 0d;
		Double lon2 = 0d;
		Double distance = DistanceCalculator.calculateDistance(lat1, lon1, lat2, lon2);
		
		price = PriceEstimator.estimatePrice(distance);
		
		assertEquals(distanceActual, distance);
		assertEquals(priceActual, price);
		
	}
	
}
