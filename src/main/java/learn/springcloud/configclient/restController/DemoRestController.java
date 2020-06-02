package learn.springcloud.configclient.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class DemoRestController {

    @GetMapping("api")
    public String getString(){
        return "success";
    }

    @PostMapping("postapi")
    public String postString(){
        return "success";
    }
}