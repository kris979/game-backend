package app.hearthstone.data;

import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<CardEntity, Long> {

    List<CardEntity> findByCardType(CardType type);

    List<CardEntity> findByHealth(Integer health);

    List<CardEntity> findByAttack(Integer attack);

    List<CardEntity> findByCost(Integer cost);

    List<CardEntity> findByHealthAndAttack(Integer health, Integer attack);
}
