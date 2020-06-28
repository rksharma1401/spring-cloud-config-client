package learn.springcloud.configclient.feignclients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learn.springcloud.configclient.model.Person;


@FeignClient(name="SPRING-CLOUD-CLIENT-APP",fallback = FeignClientFallback.class)
public interface CurrentAppClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
    public String getDate();
    
    @RequestMapping(method = RequestMethod.GET, value = "/getUserList")
	public List<Person> getUserList();
}

@Component
class FeignClientFallback implements CurrentAppClient {
   
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
