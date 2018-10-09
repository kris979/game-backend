package app.model.hearthstone;

import javax.persistence.*;

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
}
