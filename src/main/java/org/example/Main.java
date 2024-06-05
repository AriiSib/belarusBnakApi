package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    public static final String BELARUS_BANK_URL = "https://belarusbank.by/api/kursExchange";
    private final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        getRate();
    }

    private static void getRate() {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BELARUS_BANK_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            List<FilialInfo> filials = getInfo(response.body());
            for (FilialInfo filial : filials) {
                System.out.println(filial);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<FilialInfo> getInfo(String response) throws JsonProcessingException {
        FilialInfo[] filials = mapper.readValue(response, FilialInfo[].class);
        return List.of(filials);
    }
}