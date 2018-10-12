package app.hearthstone.data;

import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

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

