package project.reto345.crud;

import org.springframework.data.repository.CrudRepository;
import project.reto345.model.Category;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
