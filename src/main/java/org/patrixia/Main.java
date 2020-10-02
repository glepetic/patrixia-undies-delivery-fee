package org.patrixia;

import org.patrixia.connectors.OpenCageConnection;

import com.byteowls.jopencage.model.JOpenCageLatLng;

public class Main {

	public static void main(String[] args) {
        
		JOpenCageLatLng location1 = OpenCageConnection.locate("Almirante Francisco José Seguí 650, Caballito, Buenos Aires, Argentina");
		JOpenCageLatLng location2 = OpenCageConnection.locate("Avernida Rivadavia, Balvanera, Buenos Aires, Argentina");
		
		Double distance = DistanceCalculator.calculateDistance(location1.getLat(), location1.getLng(), location2.getLat(), location2.getLng());
		
		System.out.println(distance);
		
    }
	
}
