package app.data;

import app.model.hearthstone.CardEntity;
import app.model.hearthstone.CardType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<CardEntity, Long> {

    List<CardEntity> findByCardType(CardType type);
}
