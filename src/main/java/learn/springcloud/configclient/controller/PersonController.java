package learn.springcloud.configclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.config.WebClientImpl;
import learn.springcloud.configclient.feignclients.WebservicesEureakaClient;
import learn.springcloud.configclient.model.Person;

@Controller
public class PersonController {

    @Autowired
    private WebClientImpl webClientImpl;

    @Autowired
    private WebservicesEureakaClient webservicesEureakaClient;

    @RequestMapping("/usersList")
    public String getUserList(Model m, @Autowired Authentication authentication) {
        List<Person> lst = webservicesEureakaClient.getPersonList();
        /*
         * try { Flux<Person> flux = webClientImpl.getWebClient() .get() .uri(
         * "/pc/getAllPersons") .header(HttpHeaders.CONTENT_TYPE,
         * MediaType.APPLICATION_JSON_VALUE).retrieve() .bodyToFlux(Person.class); lst =
         * flux.collectList().block(); } catch (Exception e) { lst =
         * userClient.getUserList(); }
         */

        m.addAttribute("personString", lst.toString());
        m.addAttribute("personList", lst);
        if (authentication != null)
            m.addAttribute("userName", authentication.getName());
        else
            m.addAttribute("userName", "Guest");
        // name of view
        return "usersList";
    }
    
    @RequestMapping("/addUser")
    public String addUser(Model m, @Autowired Authentication authentication) {
 
        if (authentication != null)
            m.addAttribute("userName", authentication.getName());
        else
            m.addAttribute("userName", "Guest");
        // name of view
        return "addUser";
    }
    
}