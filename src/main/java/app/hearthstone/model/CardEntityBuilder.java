package app.hearthstone.model;

public class CardEntityBuilder {
    private String name;
    private String rarity;
    private Integer health;
    private Integer attack;
    private CardType cardType;
    private String race;
    private Integer cost;
    private String cardClass;

    public CardEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CardEntityBuilder withRarity(String rarity) {
        this.rarity = rarity;
        return this;
    }

    public CardEntityBuilder withHealth(Integer health) {
        this.health = health;
        return this;
    }

    public CardEntityBuilder withAttack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public CardEntityBuilder withCardType(CardType cardType) {
        this.cardType = cardType;
        return this;
    }

    public CardEntityBuilder withRace(String race) {
        this.race = race;
        return this;
    }

    public CardEntityBuilder withCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public CardEntityBuilder withCardClass(String cardClass) {
        this.cardClass = cardClass;
        return this;
    }

    public CardEntity createCardEntity() {
        return new CardEntity(name, rarity, health, attack, cardType, race, cost, cardClass);
    }
}