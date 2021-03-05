package com.robertrice.odinsstudy.relationship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.robertrice.odinsstudy.embeddable.ThesisToThesisEmbeddable;
import com.robertrice.odinsstudy.models.Thesis;

//This table sets up a many to many relationship between thesis while also keeping track of how strong of a relationship it is.
@Entity(name = "ThesisToThesis")
@Table(name = "thesis_to_thesis")
public class ThesisToThesisRelationship implements Serializable{
	@EmbeddedId
	@Column(columnDefinition="BIGINT(20) default '0'")
	private ThesisToThesisEmbeddable id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("thesisIdOne")
	private Thesis thesisIdOne;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("thesisIdTwo")
	private Thesis thesisIdTwo;
	
	@Column
	private Integer medianRelevanceScore;

	public ThesisToThesisRelationship() {
		super();
		this.medianRelevanceScore = 0;
	}

	public ThesisToThesisRelationship(Thesis thesisOne, Thesis thesisTwo) {
		this();
		this.thesisIdOne = thesisOne;
		this.thesisIdTwo = thesisTwo;
		this.id = new ThesisToThesisEmbeddable(thesisOne.getThesisId(), thesisTwo.getThesisId());
	}

	
	 public ThesisToThesisEmbeddable getId() { return id; }
	 
	 public void setId(ThesisToThesisEmbeddable id) { this.id = id; }
	 

	public Thesis getThesisIdOne() {
		return thesisIdOne;
	}

	public void setThesisIdOne(Thesis thesisOne) {
		this.thesisIdOne = thesisOne;
	}

	public Thesis getThesisIdTwo() {
		return thesisIdTwo;
	}

	public void setThesisIdTwo(Thesis thesisTwo) {
		this.thesisIdTwo = thesisTwo;
	}

	public Integer getMedianRelevanceScore() {
		return medianRelevanceScore;
	}

	public void setMedianRelevanceScore(Integer medianRelevanceScore) {
		this.medianRelevanceScore = medianRelevanceScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode()); 
		result = prime * result + ((medianRelevanceScore == null) ? 0 : medianRelevanceScore.hashCode());
		result = prime * result + ((thesisIdOne == null) ? 0 : thesisIdOne.hashCode());
		result = prime * result + ((thesisIdTwo == null) ? 0 : thesisIdTwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThesisToThesisRelationship other = (ThesisToThesisRelationship) obj;
		
		 if (id == null) { if (other.id != null) return false; } else if
		 (!id.equals(other.id)) return false;
		
		if (medianRelevanceScore == null) {
			if (other.medianRelevanceScore != null)
				return false;
		} else if (!medianRelevanceScore.equals(other.medianRelevanceScore))
			return false;
		if (thesisIdOne == null) {
			if (other.thesisIdOne != null)
				return false;
		} else if (!thesisIdOne.equals(other.thesisIdOne))
			return false;
		if (thesisIdTwo == null) {
			if (other.thesisIdTwo != null)
				return false;
		} else if (!thesisIdTwo.equals(other.thesisIdTwo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThesisToThesisRelationship [" + "thesisOne=" + thesisIdOne + ", thesisTwo=" + thesisIdTwo
				+ ", medianRelevanceScore=" + medianRelevanceScore + "]";
	}
	
	
}

