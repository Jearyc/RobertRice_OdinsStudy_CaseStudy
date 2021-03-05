package com.robertrice.odinsstudy.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalIdCache;

import com.robertrice.odinsstudy.relationship.ThesisToSourceRelationship;
import com.robertrice.odinsstudy.relationship.ThesisToThesisRelationship;

import org.hibernate.annotations.CacheConcurrencyStrategy;

//this table stores all the data on thesis
@Entity(name = "Thesis")
@Table(name = "thesis")
public class Thesis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long thesisId;
	private String thesisDescription;
	private Integer thesisScore;
	private Date timeCreated;
	private Date lastUpdated;
	
	@ManyToMany
	private List<Category> categories;

	public Thesis() {
		super();
		this.timeCreated = new Date();
		this.lastUpdated = new Date();
		this.thesisScore = 0;
	}

	public Thesis(String thesisDescription) {
		this();
		this.thesisDescription = thesisDescription;
	}

	public Long getThesisId() {
		return thesisId;
	}

	public void setThesisId(Long thesisId) {
		this.thesisId = thesisId;
	}

	public String getThesisDescription() {
		return thesisDescription;
	}

	public void setThesisDescription(String thesisDescription) {
		this.thesisDescription = thesisDescription;
	}

	public Integer getThesisScore() {
		return thesisScore;
	}

	public void setThesisScore(Integer thesisScore) {
		this.thesisScore = thesisScore;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((thesisDescription == null) ? 0 : thesisDescription.hashCode());
		result = prime * result + ((thesisId == null) ? 0 : thesisId.hashCode());
		result = prime * result + ((thesisScore == null) ? 0 : thesisScore.hashCode());
		result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
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
		Thesis other = (Thesis) obj;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (thesisDescription == null) {
			if (other.thesisDescription != null)
				return false;
		} else if (!thesisDescription.equals(other.thesisDescription))
			return false;
		if (thesisId == null) {
			if (other.thesisId != null)
				return false;
		} else if (!thesisId.equals(other.thesisId))
			return false;
		if (thesisScore == null) {
			if (other.thesisScore != null)
				return false;
		} else if (!thesisScore.equals(other.thesisScore))
			return false;
		if (timeCreated == null) {
			if (other.timeCreated != null)
				return false;
		} else if (!timeCreated.equals(other.timeCreated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Thesis [thesisId=" + thesisId + ", thesisDescription=" + thesisDescription + ", thesisScore="
				+ thesisScore + ", timeCreated=" + timeCreated + ", lastUpdated=" + lastUpdated + ", categories="
				+ categories + "]";
	}
	
	

}
