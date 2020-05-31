package learn.springcloud.configclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.config.WebClientImpl;
import learn.springcloud.configclient.model.Person;
import reactor.core.publisher.Flux;
 
@Controller
public class PersonController {

    
    @Autowired
    private WebClientImpl webClientImpl;

    @RequestMapping("/usersList")
    public String getUserList(Model m,@Autowired Authentication authentication) {
        
        Flux<Person> flux = webClientImpl.getWebClient()
                .get()
                .uri(
                "/pc/getAllPersons")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).retrieve() 
                .bodyToFlux(Person.class);

        List<Person> lst = flux.collectList().block();   
        m.addAttribute("personString", lst.toString());
        m.addAttribute("personList", lst);
        m.addAttribute("userName",authentication.getName());
        // name of view
        return "usersList";
    }

}