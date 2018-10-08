package app.data;

import app.model.Student;
import app.model.hearthstone.CardEntity;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<CardEntity, Long> {
}
