package app.hearthstone.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CardEntity {
    @Id
    @SequenceGenerator(name = "COL_GEN", sequenceName = "COL_SQE",schema="TEST")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COL_GEN")
    private Long id;

    private String name;
    private String rarity;
    private Integer health;
    private Integer attack;
    private CardType cardType;
    private String race;
    private Integer cost;
    private String cardClass;

    public CardEntity() {
    }

    public CardEntity(String name, String rarity, Integer health, Integer attack, CardType cardType, String race, Integer cost, String cardClass) {
        this.name = name;
        this.rarity = rarity;
        this.health = health;
        this.attack = attack;
        this.cardType = cardType;
        this.race = race;
        this.cost = cost;
        this.cardClass = cardClass;
    }

    @Override
    public String toString() {
        return "CardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rarity='" + rarity + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", cardType=" + cardType +
                ", race='" + race + '\'' +
                ", cost=" + cost +
                ", cardClass='" + cardClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(rarity, that.rarity) &&
                Objects.equals(health, that.health) &&
                Objects.equals(attack, that.attack) &&
                cardType == that.cardType &&
                Objects.equals(race, that.race) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(cardClass, that.cardClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rarity, health, attack, cardType, race, cost, cardClass);
    }

}
