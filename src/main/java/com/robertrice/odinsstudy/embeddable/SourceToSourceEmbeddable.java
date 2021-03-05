package com.robertrice.odinsstudy.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//This is the composite key for source to source relationships
@Embeddable
public class SourceToSourceEmbeddable implements Serializable{
	private Long sourceIdOne;
	
	private Long sourceIdTwo;

	public SourceToSourceEmbeddable() {
		super();
	}

	public SourceToSourceEmbeddable(Long sourceIdOne, Long sourceIdTwo) {
		super();
		this.sourceIdOne = sourceIdOne;
		this.sourceIdTwo = sourceIdTwo;
	}

	public Long getSourceIdOne() {
		return sourceIdOne;
	}

	public void setSourceIdOne(Long sourceIdOne) {
		this.sourceIdOne = sourceIdOne;
	}

	public Long getSourceIdTwo() {
		return sourceIdTwo;
	}

	public void setSourceIdTwo(Long sourceIdTwo) {
		this.sourceIdTwo = sourceIdTwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		SourceToSourceEmbeddable other = (SourceToSourceEmbeddable) obj;
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
