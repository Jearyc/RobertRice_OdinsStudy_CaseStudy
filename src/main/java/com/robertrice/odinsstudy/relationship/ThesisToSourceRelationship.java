package com.robertrice.odinsstudy.relationship;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.robertrice.odinsstudy.embeddable.ThesisToSourceEmbeddable;
import com.robertrice.odinsstudy.models.Source;
import com.robertrice.odinsstudy.models.Thesis;

//This table sets up a many to many relationship between a thesis and a source while also keeping track of how strong of a relationship it is.
@Entity(name = "ThesisToSource")
@Table(name = "thesis_to_source")
public class ThesisToSourceRelationship {
	@EmbeddedId
	ThesisToSourceEmbeddable id;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("thesisId")
	private Thesis thesisId;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@MapsId("sourceId")
	private Source sourceId;
	
	@Column
	private Integer medianRelevanceScore;

	public ThesisToSourceRelationship() {
		super();
		this.medianRelevanceScore = 0;
	}

	public ThesisToSourceRelationship(Thesis thesisId, Source sourceId) {
		this();
		this.thesisId = thesisId;
		this.sourceId = sourceId;
		this.id = new ThesisToSourceEmbeddable(thesisId.getThesisId(), sourceId.getSourceId());
	}

	public ThesisToSourceEmbeddable getId() {
		return id;
	}

	public void setId(ThesisToSourceEmbeddable id) {
		this.id = id;
	}

	public Thesis getThesisId() {
		return thesisId;
	}

	public void setThesisId(Thesis thesisId) {
		this.thesisId = thesisId;
	}

	public Source getSourceId() {
		return sourceId;
	}

	public void setSourceId(Source sourceId) {
		this.sourceId = sourceId;
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
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((thesisId == null) ? 0 : thesisId.hashCode());
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
		ThesisToSourceRelationship other = (ThesisToSourceRelationship) obj;
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
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (thesisId == null) {
			if (other.thesisId != null)
				return false;
		} else if (!thesisId.equals(other.thesisId))
			return false;
		return true;
	}

}
