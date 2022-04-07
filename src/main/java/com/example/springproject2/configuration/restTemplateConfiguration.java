package com.example.springproject2.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
// in Spring 5，we no longer use RestTemplate, and suggest use WebClient, which support asynchronous call.
@Configuration
public class restTemplateConfiguration {

    private final CloseableHttpClient httpClient;

    @Autowired
    public restTemplateConfiguration(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }


}
