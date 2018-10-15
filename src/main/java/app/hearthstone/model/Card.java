package app.hearthstone.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cardId",
        "dbfId",
        "name",
        "race",
        "health",
        "attack",
        "durability",
        "armor",
        "cardSet",
        "type",
        "faction",
        "rarity",
        "cost",
        "text",
        "flavor",
        "artist",
        "collectible",
        "elite",
        "playerClass",
        "howToGet",
        "howToGetGold",
        "img",
        "imgGold",
        "locale",
        "mechanics"
})
public class Card {

    @JsonProperty("cardId")
    private String cardId;
    @JsonProperty("dbfId")
    private String dbfId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("race")
    private String race;
    @JsonProperty("health")
    private Integer health;
    @JsonProperty("attack")
    private Integer attack;
    @JsonProperty("durability")
    private Integer durability;
    @JsonProperty("armor")
    private Integer armor;
    @JsonProperty("cardSet")
    private String cardSet;
    @JsonProperty("type")
    private String type;
    @JsonProperty("faction")
    private String faction;
    @JsonProperty("rarity")
    private String rarity;
    @JsonProperty("cost")
    private Integer cost;
    @JsonProperty("text")
    private String text;
    @JsonProperty("flavor")
    private String flavor;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("collectible")
    private Boolean collectible;
    @JsonProperty("elite")
    private Boolean elite;
    @JsonProperty("playerClass")
    private String playerClass;
    @JsonProperty("howToGet")
    private String howToGet;
    @JsonProperty("howToGetGold")
    private String howToGetGold;
    @JsonProperty("img")
    private String img;
    @JsonProperty("imgGold")
    private String imgGold;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("mechanics")
    private List<Mechanic> mechanics = null;

    @JsonProperty("cardId")
    public String getCardId() {
        return cardId;
    }

    @JsonProperty("cardId")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @JsonProperty("dbfId")
    public String getDbfId() {
        return dbfId;
    }

    @JsonProperty("dbfId")
    public void setDbfId(String dbfId) {
        this.dbfId = dbfId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    @JsonProperty("health")
    public Integer getHealth() {
        return health;
    }

    @JsonProperty("health")
    public void setHealth(Integer health) {
        this.health = health;
    }

    @JsonProperty("attack")
    public Integer getAttack() {
        return attack;
    }

    @JsonProperty("attack")
    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    @JsonProperty("durability")
    public Integer getDurability() {
        return durability;
    }

    @JsonProperty("durability")
    public void setDurability(Integer durability) {
        this.durability = durability;
    }

    @JsonProperty("armor")
    public Integer getArmor() {
        return armor;
    }

    @JsonProperty("armor")
    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    @JsonProperty("cardSet")
    public String getCardSet() {
        return cardSet;
    }

    @JsonProperty("cardSet")
    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("faction")
    public String getFaction() {
        return faction;
    }

    @JsonProperty("faction")
    public void setFaction(String faction) {
        this.faction = faction;
    }

    @JsonProperty("rarity")
    public String getRarity() {
        return rarity;
    }

    @JsonProperty("rarity")
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @JsonProperty("cost")
    public Integer getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("flavor")
    public String getFlavor() {
        return flavor;
    }

    @JsonProperty("flavor")
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @JsonProperty("artist")
    public String getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @JsonProperty("collectible")
    public Boolean getCollectible() {
        return collectible;
    }

    @JsonProperty("collectible")
    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }

    @JsonProperty("elite")
    public Boolean getElite() {
        return elite;
    }

    @JsonProperty("elite")
    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    @JsonProperty("playerClass")
    public String getPlayerClass() {
        return playerClass;
    }

    @JsonProperty("playerClass")
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    @JsonProperty("howToGet")
    public String getHowToGet() {
        return howToGet;
    }

    @JsonProperty("howToGet")
    public void setHowToGet(String howToGet) {
        this.howToGet = howToGet;
    }

    @JsonProperty("howToGetGold")
    public String getHowToGetGold() {
        return howToGetGold;
    }

    @JsonProperty("howToGetGold")
    public void setHowToGetGold(String howToGetGold) {
        this.howToGetGold = howToGetGold;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    @JsonProperty("imgGold")
    public String getImgGold() {
        return imgGold;
    }

    @JsonProperty("imgGold")
    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("mechanics")
    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    @JsonProperty("mechanics")
    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

}