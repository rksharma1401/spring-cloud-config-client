package learn.springcloud.configclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("SPRING-CLOUD-CLIENT-APP")
public interface DateClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
	public String getDate();
}