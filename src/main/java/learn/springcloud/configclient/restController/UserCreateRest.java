package learn.springcloud.configclient.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learn.springcloud.configclient.dao.UserRepo;
import learn.springcloud.configclient.model.User;

@RestController("/userApi")
public class UserCreateRest {
    
    @Autowired
    UserRepo  userRepo;

    @GetMapping("/addUser")
    public String addUser() {
        try{   
         User u=new User("user", "password", true, "ROLE_USER");
        User u1=new User("merchant", "password", true, "ROLE_MERCHANT");
        User u2=new User("ravi", "password", true, "ROLE_USER,ROLE_MERCHANT,ROLE_LEDGER");
        userRepo.save(u);
        userRepo.save(u1);
        userRepo.save(u2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Success";
    }

    @PostMapping("/postUser")
    public String postUser(@RequestBody User user) {
        try{    
        userRepo.save(user); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Success";
    }
    
}