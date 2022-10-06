package com.emse.spring.faircorp.dtodist;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RestController // (1)
@RequestMapping("/api/adressSearchService") // (2)
@Transactional // (3)
public class AdressSearchService {
    private final RestTemplate restTemplate;

    public AdressSearchService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("https://api-adresse.data.gouv.fr").build();
    }

    @GetMapping(path = "/{params}")
    public List<ApiGouvAdressDto> retourneListe(@PathVariable List<String> params) {
        String uri = UriComponentsBuilder.fromUriString("/search")
                .queryParam("q", params)
                .queryParam("limit", 15)
                .build()
                .toUriString();
        ApiGouvResponseDto apiGouvResponseDto = restTemplate.getForObject(uri, ApiGouvResponseDto.class);
        return apiGouvResponseDto.getFeatures().stream().map(ApiGouvFeatureDto::getProperties).collect(Collectors.toList());
    }
}
