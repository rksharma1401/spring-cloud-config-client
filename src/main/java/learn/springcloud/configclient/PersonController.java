package learn.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@RefreshScope
@Controller
public class PersonController {
    
    @Value("${userDbRestApp}")
    String userDbRestApp;

    @RequestMapping("/usersList")
	public String getRate(Model m) {

		m.addAttribute("userDbRestApp", userDbRestApp); 
				
		//name of view
		return "usersList";
	}

}