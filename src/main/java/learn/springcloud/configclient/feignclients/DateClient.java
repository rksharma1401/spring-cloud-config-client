package learn.springcloud.configclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="SPRING-CLOUD-CLIENT-APP",fallback = FeignClientFallback.class)
public interface DateClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
	public String getDate();
}

class FeignClientFallback implements DateClient {
   
    @Override
    public String getDate() { 
        return "No Date";
    }
}