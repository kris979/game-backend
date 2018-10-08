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

    public CardEntity(String name, String rarity, Integer health, Integer attack) {
        this.name = name;
        this.rarity = rarity;
        this.health = health;
        this.attack = attack;
    }
}
