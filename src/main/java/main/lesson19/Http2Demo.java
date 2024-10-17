package main.lesson19;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Http2Demo {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        byte[] sampleData = "Sample request body".getBytes();
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers
                        .ofInputStream(() -> new ByteArrayInputStream(sampleData)))
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .header("key1", "value1")
                .header("key2", "value2")
                .timeout(Duration.of(10, SECONDS))
                .GET()
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request1, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
