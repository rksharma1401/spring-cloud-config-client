package learn.springcloud.configclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@Controller
public class PersonController {

    @Value("${userDbRestApp}")
    String userDbRestApp;

    private WebClient webClient2;

    @RequestMapping("/usersList")
    public String getRate(Model m) {
        if (webClient2 == null) {
            webClient2 = WebClient.builder().baseUrl(userDbRestApp)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        }
        Flux<Person> flux = webClient2
                .get()
                .uri(
                "/pc/getAllPersons")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve() 
                .bodyToFlux(Person.class);

        List<Person> lst = flux.collectList().block(); 
        m.addAttribute("userDbRestApp", userDbRestApp);

        m.addAttribute("personString", lst.toString());
        m.addAttribute("personList", lst);
        // name of view
        return "usersList";
    }

}