package org.patrixia;

import java.text.DecimalFormat;

public class DistanceCalculator {

    private DistanceCalculator() {}
    
    
    /*
     * Recibe texto en formato de coordenada GPS de la forma
     * -34.618344, -58.455023
     * 
     */
    public static Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
    	
    	Double distance = distanceInKmBetweenEarthCoordinates(lat1, lon1, lat2, lon2);
    	
    	DecimalFormat df = new DecimalFormat("#.###");
    	
    	distance = Double.parseDouble(df.format(distance));
    	
        return distance;
    }
    
    private static Double degreesToRadians(Double degrees) {
    	return degrees * Math.PI / 180;
    }

    private static Double distanceInKmBetweenEarthCoordinates(Double lat1, Double lon1, Double lat2,Double lon2) {
    	  
    	Double earthRadiusKm = 6371d;

    	Double dLat = degreesToRadians(lat2-lat1);
    	Double dLon = degreesToRadians(lon2-lon1);

    	lat1 = degreesToRadians(lat1);
    	lat2 = degreesToRadians(lat2);

    	Double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
    	Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2); 
    	Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
    	
    	return earthRadiusKm * c;
    	
    }

}
