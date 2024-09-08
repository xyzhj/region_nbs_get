package zhj.region_nbs_get.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class UIDHelper {
    @Value("${http.UIDURI}")
    private String uri;

    @Value("${http.UIDURI.readTimeout}")
    private int readTimeout;

    @Value("${http.UIDURI.connectTimeout}")
    private int connectTimeout;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.rootUri(uri).setConnectTimeout(Duration.ofSeconds(connectTimeout)).setReadTimeout(Duration.ofSeconds(readTimeout)).build();

    }
}
