package learn.springcloud.configclient.dao; 
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}