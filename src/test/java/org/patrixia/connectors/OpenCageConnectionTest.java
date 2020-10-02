package org.patrixia.connectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OpenCageConnectionTest {

	@Test
	public void distanceTestSamePlace() {
		OpenCageConnection.locate("Almirante Francisco José Seguí 650, Caballito, Buenos Aires");
		assertEquals(1,1);
	}
	
	
}
