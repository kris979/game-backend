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
    private String cardClass;
    private String race;
    private Integer health;
    private Integer attack;
    private Integer cost;
    private CardType cardType;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getCardClass() {
        return cardClass;
    }

    public void setCardClass(String cardClass) {
        this.cardClass = cardClass;
    }
}
