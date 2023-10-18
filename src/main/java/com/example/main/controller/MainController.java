package com.example.main.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class MainController {

    @PostMapping("/chiamataAuth")
    public ResponseEntity<?> auth(@RequestBody JsonNode jsonBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String urlProva = "http://localhost:8081/api/authenticate";
        HttpEntity<JsonNode> requestEntity = new HttpEntity<>(jsonBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(urlProva, HttpMethod.POST, requestEntity, String.class);
        return response;
    }

    @GetMapping("/provaChiamata")
    public ResponseEntity<?> getProvaChiamata() {
        RestTemplate restTemplate = new RestTemplate();
        String urlProva = "http://localhost:8081/api/prova";
        String response = restTemplate.getForObject(urlProva, String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/provaChiamataDemo")
    public ResponseEntity<?> getProvaChiamataDemo() {
        RestTemplate restTemplate = new RestTemplate();
        String urlProva = "http://localhost:8081/demo/prova";
        String response = restTemplate.getForObject(urlProva, String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
