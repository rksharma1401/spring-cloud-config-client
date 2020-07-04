package learn.springcloud.configclient.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@FeignClient(name="WEB-SERVICE-EUREKA",fallback = WebservicesEureakaFeignClientFallback.class)
public interface WebservicesEureakaClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getDate")
    public String getDate();
}

@Component
class WebservicesEureakaFeignClientFallback implements WebservicesEureakaClient{
    @Override
    public String getDate() { 
        return "No Date from WEB-SERVICE-EUREKA";
    }
}