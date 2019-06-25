package com.restaurantcenter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AppUserServiceImpl implements AppUserService {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Value("${engine.url}")
    private String ENGINE_URL;

    @Override
    public ResponseEntity<String> getUserId() {
        RestTemplate restTemplate = new RestTemplate();
        String url = ENGINE_URL.concat("/RCD/getuserid");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        LOGGER.info("request :{}", url);
        try {
            return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            LOGGER.error("{}", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
