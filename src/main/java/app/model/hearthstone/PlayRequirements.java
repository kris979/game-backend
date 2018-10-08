package app.model.hearthstone;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "REQ_MINION_TARGET", "REQ_TARGET_TO_PLAY" })
public class PlayRequirements {

	@JsonProperty("REQ_MINION_TARGET")
	private Integer reqMinionTarget;
	@JsonProperty("REQ_TARGET_TO_PLAY")
	private Integer reqTargetToPlay;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public PlayRequirements() {
	}

	/**
	 * 
	 * @param rEQTARGETTOPLAY
	 * @param rEQMINIONTARGET
	 */
	public PlayRequirements(Integer rEQMINIONTARGET, Integer rEQTARGETTOPLAY) {
		super();
		this.reqMinionTarget = rEQMINIONTARGET;
		this.reqTargetToPlay = rEQTARGETTOPLAY;
	}

	@JsonProperty("REQ_MINION_TARGET")
	public Integer getREQMINIONTARGET() {
		return reqMinionTarget;
	}

	@JsonProperty("REQ_MINION_TARGET")
	public void setREQMINIONTARGET(Integer rEQMINIONTARGET) {
		this.reqMinionTarget = rEQMINIONTARGET;
	}

	@JsonProperty("REQ_TARGET_TO_PLAY")
	public Integer getREQTARGETTOPLAY() {
		return reqTargetToPlay;
	}

	@JsonProperty("REQ_TARGET_TO_PLAY")
	public void setREQTARGETTOPLAY(Integer rEQTARGETTOPLAY) {
		this.reqTargetToPlay = rEQTARGETTOPLAY;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("REQMINIONTARGET", reqMinionTarget)
				.append("REQTARGETTOPLAY", reqTargetToPlay).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(reqTargetToPlay).append(reqMinionTarget).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PlayRequirements) == false) {
			return false;
		}
		PlayRequirements rhs = ((PlayRequirements) other);
		return new EqualsBuilder().append(reqTargetToPlay, rhs.reqTargetToPlay)
				.append(reqMinionTarget, rhs.reqMinionTarget).isEquals();
	}

}