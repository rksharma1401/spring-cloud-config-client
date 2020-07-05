package learn.springcloud.configclient;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import learn.springcloud.configclient.feignclients.CurrentAppClient;
import learn.springcloud.configclient.feignclients.WebservicesEureakaClient;
import learn.springcloud.configclient.model.Person;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient 
@EnableFeignClients
public class ConfigclientApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}

} 


@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired 
	private CurrentAppClient client;
 
	@Autowired
	private WebservicesEureakaClient wsClient;

	// client to see if app registered or not
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}

	// register this rest service with eureka
	@RequestMapping("/getDate")
	public String getDate() {   
		return new Date().toString();
	}

	// get data from this app using eureka
	@RequestMapping("/getDateEureka")
	public String getDateSelf() {   
		return client.getDate();
	} 

	@RequestMapping("/getFallBackUser")
	public List<Person> getFallBackUser() {   
		return client.getUserList();
	}

	// get data from other app using eureka
	@RequestMapping("/getDateWSEureka")
	public String getDateWSEureka() {   
		return wsClient.getDate();
	}
}