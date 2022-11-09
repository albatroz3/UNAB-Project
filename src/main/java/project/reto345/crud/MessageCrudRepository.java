package project.reto345.crud;

import org.springframework.data.repository.CrudRepository;
import project.reto345.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
