package learn.springcloud.configclient.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.springcloud.configclient.dao.UserRepo;
import learn.springcloud.configclient.model.User;
 
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserCreateRest {
    
    @Autowired
    UserRepo  userRepo;

    @GetMapping("adduser")
    public String addUser() {
        try{   
        User u1=new User("merchant", "password", true, "ROLE_MERCHANT",1);
        u1.setId(1);
        User u2=new User("ravi", "password", true, "ROLE_USER,ROLE_MERCHANT,ROLE_LEDGER",2); 
        u2.setId(2);
        userRepo.save(u1);
        userRepo.save(u2); 
 
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Success";
    }

    @PostMapping("postuser")
    public String postUser(@RequestBody User user) {
        try{    
        userRepo.save(user); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Success";
    }
    
}