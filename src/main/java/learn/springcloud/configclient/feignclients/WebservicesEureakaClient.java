package learn.springcloud.configclient.feignclients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learn.springcloud.configclient.model.Person;
@FeignClient(name="WEB-SERVICE-EUREKA" ,fallback = WebservicesEureakaFeignClientFallback.class)
public interface WebservicesEureakaClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
    public String getDate();
    @RequestMapping(method = RequestMethod.GET, value = "/getPersonList")
	public List<Person> getPersonList();
}

  @Component
class WebservicesEureakaFeignClientFallback implements WebservicesEureakaClient{
    @Override
    public String getDate() { 
        return "No Date from WEB-SERVICE-EUREKA";
    }

    @Override
    public List<Person> getPersonList() { 
        List<Person> list= new ArrayList<Person>();
        list.add(new Person("BACKUP","PERSON",0,"WebservicesEureakaFeignClientFallback"));
        return list;
    }
} 