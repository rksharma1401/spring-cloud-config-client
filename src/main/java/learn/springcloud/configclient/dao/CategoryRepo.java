package learn.springcloud.configclient.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import learn.springcloud.configclient.model.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

  List<Category> findByCategoryName(String categoryName);

  Category findById(long id);
}