package com.robertrice.odinsstudy.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//This is the composite key for thesis to source relationships
@Embeddable
public class ThesisToSourceEmbeddable implements Serializable{
	@Column(name = "thesisId")
	private Long thesisId;
	
	@Column(name = "sourceId")
	private Long sourceId;

	public ThesisToSourceEmbeddable() {
		super();
	}

	public ThesisToSourceEmbeddable(Long thesisId, Long sourceId) {
		super();
		this.thesisId = thesisId;
		this.sourceId = sourceId;
	}

	public Long getThesisId() {
		return thesisId;
	}

	public void setThesisId(Long thesisId) {
		this.thesisId = thesisId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ThesisToSourceEmbeddable other = (ThesisToSourceEmbeddable) obj;
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
