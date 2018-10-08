package app.model.hearthstone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {

@JsonProperty("howToEarn")
private String howToEarn;	
@JsonProperty("howToEarnGolden")
private String howToEarnGolden;	
@JsonProperty("collectionText")
private String collectionText;	
@JsonProperty("artist")
private String artist;
@JsonProperty("attack")
private Integer attack;
@JsonProperty("spellDamage")
private Integer spellDamage;
@JsonProperty("cardClass")
private String cardClass;
@JsonProperty("collectible")
private Boolean collectible;
@JsonProperty("cost")
private Integer cost;
@JsonProperty("overload")
private Integer overload;
@JsonProperty("durability")
private Integer durability;
@JsonProperty("dbfId")
private Integer dbfId;
@JsonProperty("elite")
private Boolean elite;
@JsonProperty("flavor")
private String flavor;
@JsonProperty("health")
private Integer health;
@JsonProperty("id")
private String id;
@JsonProperty("mechanics")
@Valid
private List<String> mechanics = new ArrayList<String>();
@JsonProperty("name")
private String name;
@JsonProperty("playRequirements")
@Valid
@JsonIgnore
private PlayRequirements playRequirements;
@JsonProperty("race")
private String race;
@JsonProperty("rarity")
private String rarity;
@JsonProperty("referencedTags")
@Valid
private List<String> referencedTags = new ArrayList<String>();
@JsonProperty("set")
private String set;
@JsonProperty("targetingArrowText")
private String targetingArrowText;
@JsonProperty("text")
private String text;
@JsonProperty("type")
private CardType type; //HERO, MINION, SPELL, ENCHANTMENT (buff), WEAPON and HERO_POWER

/**
* No args constructor for use in serialization
* 
*/
public Card() {
}

/**
* 
* @param text
* @param set
* @param flavor
* @param rarity
* @param type
* @param health
* @param cost
* @param id
* @param cardClass
* @param name
* @param collectible
* @param mechanics
* @param dbfId
* @param artist
* @param attack
*/
public Card(String howToEarn, String howToEarnGolden, String collectionText, String artist, Integer attack, Integer spellDamage, String cardClass, Boolean collectible, Integer overload, Integer cost, Integer dbfId, Integer durability, Boolean elite, String flavor, Integer health, String id, List<String> mechanics, String name, PlayRequirements playRequirements,String race, String rarity, List<String> referencedTags, String set, String targetingArrowText, String text, CardType type) {
super();
this.howToEarn = howToEarn;
this.howToEarnGolden = howToEarnGolden;
this.collectionText = collectionText;
this.artist = artist;
this.attack = attack;
this.cardClass = cardClass;
this.collectible = collectible;
this.cost = cost;
this.spellDamage = spellDamage;
this.overload = overload;
this.dbfId = dbfId;
this.durability = durability;
this.elite = elite;
this.flavor = flavor;
this.health = health;
this.id = id;
this.mechanics = mechanics;
this.name = name;
this.playRequirements = playRequirements;
this.race = race;
this.rarity = rarity;
this.referencedTags = referencedTags;
this.set = set;
this.targetingArrowText = targetingArrowText;
this.text = text;
this.type = type;
}

@JsonProperty("howToEarn")
public String getHowToEarn() {
return howToEarn;
}

@JsonProperty("howToEarn")
public void setHowToEarn(String howToEarn) {
this.howToEarn = howToEarn;
}

@JsonProperty("howToEarnGolden")
public String getHowToEarnGolden() {
return howToEarnGolden;
}

@JsonProperty("howToEarnGolden")
public void setHowToEarnGolden(String howToEarnGolden) {
this.howToEarnGolden = howToEarnGolden;
}


@JsonProperty("collectionText")
public String getCollectionText() {
return collectionText;
}

@JsonProperty("collectionText")
public void setCollectionText(String collectionText) {
this.collectionText = collectionText;
}

@JsonProperty("artist")
public String getArtist() {
return artist;
}

@JsonProperty("artist")
public void setArtist(String artist) {
this.artist = artist;
}

@JsonProperty("attack")
public Integer getAttack() {
return attack;
}

@JsonProperty("attack")
public void setAttack(Integer attack) {
this.attack = attack;
}

@JsonProperty("spellDamage")
public Integer getSpellDamage() {
return spellDamage;
}

@JsonProperty("spellDamage")
public void setSpellDamage(Integer spellDamage) {
this.spellDamage = spellDamage;
}

@JsonProperty("cardClass")
public String getCardClass() {
return cardClass;
}

@JsonProperty("cardClass")
public void setCardClass(String cardClass) {
this.cardClass = cardClass;
}

@JsonProperty("collectible")
public Boolean getCollectible() {
return collectible;
}

@JsonProperty("collectible")
public void setCollectible(Boolean collectible) {
this.collectible = collectible;
}

@JsonProperty("cost")
public Integer getCost() {
return cost;
}

@JsonProperty("cost")
public void setCost(Integer cost) {
this.cost = cost;
}

@JsonProperty("overload")
public Integer getOverload() {
return overload;
}

@JsonProperty("overload")
public void setOverload(Integer overload) {
this.overload = overload;
}

@JsonProperty("dbfId")
public Integer getDbfId() {
return dbfId;
}

@JsonProperty("dbfId")
public void setDbfId(Integer dbfId) {
this.dbfId = dbfId;
}

@JsonProperty("durability")
public Integer getDurability() {
return durability;
}

@JsonProperty("durability")
public void setDurability(Integer durability) {
this.durability = durability;
}

@JsonProperty("elite")
public Boolean getElite() {
return elite;
}

@JsonProperty("elite")
public void setElite(Boolean elite) {
this.elite = elite;
}

@JsonProperty("flavor")
public String getFlavor() {
return flavor;
}

@JsonProperty("flavor")
public void setFlavor(String flavor) {
this.flavor = flavor;
}

@JsonProperty("health")
public Integer getHealth() {
return health;
}

@JsonProperty("health")
public void setHealth(Integer health) {
this.health = health;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("mechanics")
public List<String> getMechanics() {
return mechanics;
}

@JsonProperty("mechanics")
public void setMechanics(List<String> mechanics) {
this.mechanics = mechanics;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonIgnore
@JsonProperty("playRequirements")
public PlayRequirements getPlayRequirements() {
return playRequirements;
}

@JsonIgnore
@JsonProperty("playRequirements")
public void setPlayRequirements(PlayRequirements playRequirements) {
this.playRequirements = playRequirements;
}

@JsonProperty("race")
public String getRace() {
return race;
}

@JsonProperty("race")
public void setRace(String race) {
this.race = race;
}

@JsonProperty("rarity")
public String getRarity() {
return rarity;
}

@JsonProperty("rarity")
public void setRarity(String rarity) {
this.rarity = rarity;
}

@JsonProperty("referencedTags")
public List<String> getReferencedTags() {
return referencedTags;
}

@JsonProperty("referencedTags")
public void setReferencedTags(List<String> referencedTags) {
this.referencedTags = referencedTags;
}

@JsonProperty("set")
public String getSet() {
return set;
}

@JsonProperty("set")
public void setSet(String set) {
this.set = set;
}

@JsonProperty("targetingArrowText")
public String getTargetingArrowText() {
return targetingArrowText;
}

@JsonProperty("targetingArrowText")
public void setTargetingArrowText(String targetingArrowText) {
this.targetingArrowText = targetingArrowText;
}

@JsonProperty("text")
public String getText() {
return text;
}

@JsonProperty("text")
public void setText(String text) {
this.text = text;
}

@JsonProperty("type")
public CardType getType() {
return type;
}

@JsonProperty("type")
public void setType(CardType type) {
this.type = type;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("artist", artist).append("attack", attack).append("cardClass", cardClass).append("collectible", collectible).append("cost", cost).append("dbfId", dbfId).append("flavor", flavor).append("health", health).append("id", id).append("mechanics", mechanics).append("name", name).append("rarity", rarity).append("set", set).append("text", text).append("type", type).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(text).append(set).append(rarity).append(flavor).append(type).append(health).append(cost).append(id).append(cardClass).append(name).append(mechanics).append(collectible).append(dbfId).append(attack).append(artist).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof Card) == false) {
return false;
}
Card rhs = ((Card) other);
return new EqualsBuilder().append(text, rhs.text).append(set, rhs.set).append(rarity, rhs.rarity).append(flavor, rhs.flavor).append(type, rhs.type).append(health, rhs.health).append(cost, rhs.cost).append(id, rhs.id).append(cardClass, rhs.cardClass).append(name, rhs.name).append(mechanics, rhs.mechanics).append(collectible, rhs.collectible).append(dbfId, rhs.dbfId).append(attack, rhs.attack).append(artist, rhs.artist).isEquals();
}

}