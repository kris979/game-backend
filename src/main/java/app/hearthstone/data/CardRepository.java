package app.hearthstone.data;

import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    //documentation how to write queries
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query

    List<CardEntity> findByCardType(CardType type);

    List<CardEntity> findByHealth(Integer health);

    List<CardEntity> findByAttack(Integer attack);

    List<CardEntity> findByCost(Integer cost);

    List<CardEntity> findByHealthAndAttack(Integer health, Integer attack);

    @Query("select card from CardEntity card where card.health = :health and (:attack is null or card.attack = :attack)")
    public List<CardEntity> findByHealthAndOptionalAttack(@Param("health") Integer health, @Param("attack") Optional<Integer> attack);

}


