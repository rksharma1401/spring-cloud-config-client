package learn.springcloud.configclient.feignclients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import learn.springcloud.configclient.model.Person;

@Component
class FeignClientFallback implements DateClient {
   
    @Override
    public String getDate() { 
        return "No Date";
    }

    @Override
    public List<Person> getUserList() { 
        List<Person> list= new ArrayList<Person>();
        list.add(new Person("BACKUP","PERSON",0,"FeignClientUserFallback"));
        return list;
    
    }
    
}