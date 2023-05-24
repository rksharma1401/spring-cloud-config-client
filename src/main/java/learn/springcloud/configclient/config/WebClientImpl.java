package learn.springcloud.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

//@RefreshScope
@Configuration
public class WebClientImpl {
    
    private WebClient webClient;

    public WebClientImpl(){
        System.out.println(" ***************************************** Creating WebClientImpl *****************************************");
    }

   // @Value("${userDbRestApp:abc}")  
    String userDbRestApp="http://localhost"; 
 

    public WebClient getWebClient() {
        System.out.println(" ***************************************** calling getWebClient *****************************************");
        if(webClient==null  ){
            System.out.println(" ***************************************** creating WebClient *****************************************");
            webClient = WebClient.builder().baseUrl(userDbRestApp)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build(); 
        }
        return webClient;
    }
}
