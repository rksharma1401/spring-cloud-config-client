package learn.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientImpl {
    private final WebClient webClient;

    WebClientImpl(@Value("${userDbRestApp}")  String userDbRestApp){
     webClient = WebClient.builder().baseUrl(userDbRestApp)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build(); 
    }

    public WebClient getWebClient() {
        return webClient;
    }
}