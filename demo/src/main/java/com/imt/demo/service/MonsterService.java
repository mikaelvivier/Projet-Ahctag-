package com.imt.demo.service;

import com.imt.demo.model.Monster;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MonsterService {

    private final WebClient webClient;

    public MonsterService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public Mono<Monster> getMonsterById(String monsterId) {
        return webClient.get()
                .uri("/monster/" + monsterId)
                .retrieve()
                .bodyToMono(Monster.class);
    }
}
