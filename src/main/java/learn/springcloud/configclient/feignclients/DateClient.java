package learn.springcloud.configclient.feignclients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learn.springcloud.configclient.model.Person;


@FeignClient(name="SPRING-CLOUD-CLIENT-APP",fallback = FeignClientFallback.class)
public interface DateClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
    public String getDate();
    
    @RequestMapping(method = RequestMethod.GET, value = "/getUserList")
	public List<Person> getUserList();
}

