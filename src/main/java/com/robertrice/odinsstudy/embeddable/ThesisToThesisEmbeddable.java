package com.robertrice.odinsstudy.embeddable;

import java.io.Serializable;

import javax.persistence.Embeddable;
//This is the composite key for thesis to thesis relationships
@Embeddable
public class ThesisToThesisEmbeddable implements Serializable{
	private Long thesisIdOne = 0L;
	
	private Long thesisIdTwo = 0L;

	public ThesisToThesisEmbeddable() {
		super();
	}

	public ThesisToThesisEmbeddable(Long thesisIdOne, Long thesisIdTwo) {
		super();
		this.thesisIdOne = thesisIdOne;
		this.thesisIdTwo = thesisIdTwo;
	}

	public Long getThesisIdOne() {
		return thesisIdOne;
	}

	public void setThesisIdOne(Long thesisIdOne) {
		this.thesisIdOne = thesisIdOne;
	}

	public Long getThesisIdTwo() {
		return thesisIdTwo;
	}

	public void setThesisIdTwo(Long thesisIdTwo) {
		this.thesisIdTwo = thesisIdTwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ThesisToThesisEmbeddable other = (ThesisToThesisEmbeddable) obj;
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
		return "ThesisToThesisEmbeddable [thesisIdOne=" + thesisIdOne + ", thesisIdTwo=" + thesisIdTwo + "]";
	}
	
}
