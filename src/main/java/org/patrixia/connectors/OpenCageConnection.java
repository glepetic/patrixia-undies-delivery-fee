package org.patrixia.connectors;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;

public class OpenCageConnection {
	
	/*
	 * Los resultados estan limitados a CABA
	 */
	public static JOpenCageLatLng locate(String location) {
		
	//la api key es free, limite 2500 request por dia creo
	JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("c4019cb8c5fd47f795ae26765d28e644");
	JOpenCageForwardRequest request = new JOpenCageForwardRequest(location);
	request.setRestrictToCountryCode("ar"); // restrict results to a specific country
//	request.setBounds(-34.688464, -58.535977, -34.530226, -58.358136); // restrict results to a geographic bounding box (southWestLng, southWestLat, northEastLng, northEastLat)

	JOpenCageResponse response = jOpenCageGeocoder.forward(request);
	JOpenCageLatLng result = response.getFirstPosition(); // get the coordinate pair of the first result
	
	return result;
	
	}
}
