package com.github.moinmarcell.rickandmorty.controller;

import com.github.moinmarcell.rickandmorty.model.Response;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    @GetMapping("/characters")
    Response getCharacterNames(){

        return WebClient
                .builder()
                .baseUrl("https://rickandmortyapi.com/api/character")
                .build()
                .method(HttpMethod.GET)
                //.uri("/api/character")
                .exchangeToMono(
                        clientResponse -> clientResponse.bodyToMono(Response.class)
                )
                .block();
    }

}
