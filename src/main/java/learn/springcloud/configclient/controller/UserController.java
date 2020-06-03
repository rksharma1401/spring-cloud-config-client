package learn.springcloud.configclient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springcloud.configclient.dao.UserRepo;
import learn.springcloud.configclient.model.User;
 
@Controller 
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepo userRepoImpl;
 
    @RequestMapping("/list")
    public String getUSerList(Model m,@Autowired Authentication authentication) {
        Iterable<User> iterator = userRepoImpl.findAll();
       
        List<User> lst =  new ArrayList<>();
        iterator.forEach(e->lst.add(e));

        m.addAttribute("userList", lst);
        if(authentication!=null)
            m.addAttribute("userName",authentication.getName());
        // name of view 
        return "usersList";
    }
}