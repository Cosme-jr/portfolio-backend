package com.cosme.portfolio_backend.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IAService {
    @Value("${google.api.key:default_key}") // Adicionei valor padrão temporário para evitar erro na injeção, substitua pela real
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient(); // Instancia o cliente HTTP uma vez para reutilização

    public String generateResponse(String query) {
        if (apiKey == null || apiKey.equals("default_key")) {
            throw new IllegalStateException("Chave da API Google não configurada. Verifique application.properties.");
        }

        String prompt = "Responda como se fosse o Cosme, um desenvolvedor full stack. Seja breve e direto ao ponto. Pergunta: " + query;

        JSONObject json = new JSONObject();
        json.put("contents", new JSONObject().put("parts", new JSONArray().put(prompt)));

        Request request = new Request.Builder()
                .url("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey)
                .post(RequestBody.create(json.toString(), MediaType.parse("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na API: " + response.code() + " - " + response.message());
            }
            String responseBody = response.body().string();
            JSONObject responseJson = new JSONObject(responseBody);
            return responseJson.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
        } catch (IOException e) {
            throw new RuntimeException("Erro na integração com IA: " + e.getMessage(), e);
        }
    }
}
