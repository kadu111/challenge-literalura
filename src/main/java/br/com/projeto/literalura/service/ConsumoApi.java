package br.com.projeto.literalura.service;

import br.com.projeto.literalura.dto.GutendexResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsumoApi {

    private static final String BASE_URL = "https://gutendex.com/books/";
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public ConsumoApi() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public GutendexResponse buscarLivros(String termoBusca) {
        String url = BASE_URL + "?search=" + termoBusca;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return objectMapper.readValue(response.body(), GutendexResponse.class);
            } else {
                System.out.println("Erro na requisição: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consumir API: " + e.getMessage());
        }

        return null;
    }
}