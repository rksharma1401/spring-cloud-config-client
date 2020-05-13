package learn.springcloud.configclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope; 
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RefreshScope
@Controller
public class PersonController {

    
    @Autowired
    private WebClientImpl webClientImpl;

    @RequestMapping("/usersList")
    public String getRate(Model m) {
        
        Flux<Person> flux = webClientImpl.getWebClient()
                .get()
                .uri(
                "/pc/getAllPersons")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve() 
                .bodyToFlux(Person.class);

        List<Person> lst = flux.collectList().block();   
        m.addAttribute("personString", lst.toString());
        m.addAttribute("personList", lst);
        // name of view
        return "usersList";
    }

}