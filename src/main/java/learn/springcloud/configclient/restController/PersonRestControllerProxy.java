package learn.springcloud.configclient.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.springcloud.configclient.feignclients.WebservicesEureakaClient;
import learn.springcloud.configclient.model.Person;

@RestController
@RequestMapping("person")
@CrossOrigin
public class PersonRestControllerProxy {

	@Autowired
	private WebservicesEureakaClient wsClient;

	@PostMapping("addPerson")
	public String addPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String place,
			@RequestParam int age) {

		Person p = new Person(firstName, lastName, age, place);
		int id = wsClient.addPerson(p);

		return id != -1 ? "success with Id : " + id : "Error in saving person ,code :" + id;
	}

	public List<Person> getPersonList() {
		return wsClient.getPersonList();
	}
}
