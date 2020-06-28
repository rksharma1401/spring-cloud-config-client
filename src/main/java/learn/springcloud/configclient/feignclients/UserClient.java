package learn.springcloud.configclient.feignclients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learn.springcloud.configclient.model.Person;

@FeignClient(name="USER-APP",fallback = FeignClientUserFallback.class)
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getPersonList")
	public List<Person> getPersonList();
}

class FeignClientUserFallback implements UserClient  {
   
    @Override
    public List<Person> getPersonList() { 
        List<Person> list= new ArrayList<Person>();
        list.add(new Person("BACKUP","PERSON",0,"FeignClientUserFallback"));
        return list;
    
    }
}