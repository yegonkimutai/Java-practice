package com.kenzie.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class CustomHttpClient {
    public static Optional<Clue> fetchRandomClue() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jservice.kenzie.academy/api/random"))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Parse the response and create a Clue object
            // You may need to use a JSON library to parse the response JSON
            // For simplicity, we'll skip JSON parsing here.
            if (response.statusCode() == 200) {
                // Parse the response body as needed (e.g., using a JSON library)
                // For simplicity, we'll skip JSON parsing here and assume you have Clue data.
    
                Clue clue = new Clue("What is the capital of France?", "Paris");
                return Optional.of(clue);
            } else {
                // Handle non-200 status codes or other error cases
                return Optional.empty();
            }
    }
}




// public class CustomHttpClient {
//     //TODO: Write sendGET method that takes URL and returns response
//     public static String sendGET(String URLString) {
//         //** Start of GET request algorithm

//     }
// }
