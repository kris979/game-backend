package app.data;

import app.model.CardEntity;
import app.model.CardType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DbCardRepository extends JpaRepository<CardEntity, Long> {

    //documentation how to write queries
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.sample-app.finders.strategies
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query

    List<CardEntity> findByCardType(CardType type);

    List<CardEntity> findByHealth(Integer health);

    List<CardEntity> findByAttack(Integer attack);

    List<CardEntity> findByCost(Integer cost);

    @Query("select card from CardEntity card where (:health is null or card.health = :health) " +
                                                "and (:attack is null or card.attack = :attack)" +
                                                "and (:rarity is null or card.rarity = :rarity)" +
                                                "and (:cost is null or card.cost = :cost)")
    Page<CardEntity> findBy(@Param("health") Integer health,
                            @Param("attack") Integer attack,
                            @Param("cost") Integer cost,
                            @Param("rarity") String rarity,
                            Pageable pageRequest);
}


