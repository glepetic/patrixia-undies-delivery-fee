package org.patrixia.connectors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.patrixia.utils.IteratorUtils.foldL;

public class GeoServiceConnector {

    //must create environment variable named OPEN_CAGE_API_KEY in execution environment (local, heroku, etc.)
    private static final String API_KEY = System.getenv("OPEN_CAGE_API_KEY");
    //TODO: place url in spring boot properties file
    private static final String BASE_URL = "https://api.opencagedata.com/geocode/v1/json";
    private URL requestURL;

    public GeoServiceConnector(String address) {
        this.requestURL = getFullURL(address);
    }

    public String get() {
        try {
            HttpURLConnection connection = (HttpURLConnection) requestURL.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) response.append(inputLine);
                in.close();

                System.out.println(response.toString());
                return response.toString();
            } else {
                throw new RuntimeException("Unable to execute HTTP get");
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to execute HTTP get");
        }

    }

    private URL getFullURL(String address) {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("q", address);
        queryParams.put("key", API_KEY);
        String urlWithParams = addQueryParams(BASE_URL, queryParams);
        return toURL(urlWithParams);
    }

    private String addQueryParams(String raw, Map<String, String> queryParams) {
        return foldL((x,y) -> y.concat(x).concat("=").concat(queryParams.get(x)), raw.concat("?"), queryParams.keySet());
    }

    private static URL toURL(String raw) {
        try {
            return new URL(raw);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL was not formed correctly...");
        }
    }

}
