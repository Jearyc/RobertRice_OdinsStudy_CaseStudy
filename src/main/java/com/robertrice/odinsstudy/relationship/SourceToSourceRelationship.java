package com.robertrice.odinsstudy.relationship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.robertrice.odinsstudy.embeddable.SourceToSourceEmbeddable;
import com.robertrice.odinsstudy.models.Source;

//This table sets up a many to many relationship between sources while also keeping track of how strong of a relationship it is.
@Entity(name = "SourceToSource")
@Table(name = "source_to_source")
public class SourceToSourceRelationship implements Serializable{
	@EmbeddedId
	@Column(columnDefinition="BIGINT(20) default '0'")
	private SourceToSourceEmbeddable id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("sourceIdOne")
	private Source sourceIdOne;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("sourceIdTwo")
	private Source sourceIdTwo;
	
	@Column
	private Integer medianRelevanceScore;

	public SourceToSourceRelationship() {
		super();
		this.medianRelevanceScore = 0;
	}

	public SourceToSourceRelationship(Source sourceIdOne, Source sourceIdTwo) {
		this();
		this.sourceIdOne = sourceIdOne;
		this.sourceIdTwo = sourceIdTwo;
		this.id = new SourceToSourceEmbeddable(sourceIdOne.getSourceId(), sourceIdTwo.getSourceId());
	}

	public SourceToSourceEmbeddable getId() {
		return id;
	}

	public void setId(SourceToSourceEmbeddable id) {
		this.id = id;
	}

	public Source getSourceIdOne() {
		return sourceIdOne;
	}

	public void setSourceIdOne(Source sourceIdOne) {
		this.sourceIdOne = sourceIdOne;
	}

	public Source getSourceIdTwo() {
		return sourceIdTwo;
	}

	public void setSourceIdTwo(Source sourceIdTwo) {
		this.sourceIdTwo = sourceIdTwo;
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
		result = prime * result + ((sourceIdOne == null) ? 0 : sourceIdOne.hashCode());
		result = prime * result + ((sourceIdTwo == null) ? 0 : sourceIdTwo.hashCode());
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
		SourceToSourceRelationship other = (SourceToSourceRelationship) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medianRelevanceScore == null) {
			if (other.medianRelevanceScore != null)
				return false;
		} else if (!medianRelevanceScore.equals(other.medianRelevanceScore))
			return false;
		if (sourceIdOne == null) {
			if (other.sourceIdOne != null)
				return false;
		} else if (!sourceIdOne.equals(other.sourceIdOne))
			return false;
		if (sourceIdTwo == null) {
			if (other.sourceIdTwo != null)
				return false;
		} else if (!sourceIdTwo.equals(other.sourceIdTwo))
			return false;
		return true;
	}

}
