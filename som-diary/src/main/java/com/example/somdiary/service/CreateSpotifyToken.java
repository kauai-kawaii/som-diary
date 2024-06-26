//package com.example.somdiary.service;
//
//import com.wrapper.spotify.SpotifyApi;
//import com.wrapper.spotify.exceptions.SpotifyWebApiException;
//import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
//import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//@PropertySource("classpath:config.properties")
//public class CreateSpotifyToken {
//    @Value("${SPOTIFY_CLIENT_ID}")
//    private String clientId;
//    @Value("${SPOTIFY_CLIENT_SECRET}")
//    private String clientSecret;
//    private SpotifyApi spotifyApi;
//
//    @PostConstruct
//    public void init() {
//        System.out.println("clientId: " + clientId);
//        System.out.println("clientSecret: " + clientSecret);
//        this.spotifyApi = new SpotifyApi.Builder()
//                .setClientId(clientId)
//                .setClientSecret(clientSecret)
//                .build();
//    }
//
//    public String accessToken() {
//        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
//        try {
//            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
//            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
//            return spotifyApi.getAccessToken();
//        } catch (IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e) {
//            System.out.println("Error: " + e.getMessage());
//            return "error";
//        }
//    }
//}