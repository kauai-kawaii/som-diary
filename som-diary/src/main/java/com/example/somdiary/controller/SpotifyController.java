//package com.example.somdiary.controllers;
//
//import com.example.somdiary.service.CreateSpotifyToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SpotifyController {
//    @Autowired
//    private CreateSpotifyToken createSpotifyToken;
//
//    @GetMapping("/spotify/token")
//    public String getSpotifyAccessToken() {
//        return createSpotifyToken.accessToken();
//    }
//}
