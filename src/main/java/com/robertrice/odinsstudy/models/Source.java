package com.robertrice.odinsstudy.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;
import org.springframework.web.multipart.MultipartFile;

import com.robertrice.odinsstudy.relationship.SourceToSourceRelationship;
import com.robertrice.odinsstudy.relationship.ThesisToSourceRelationship;

//this table stores all the data for sources.
@Entity(name = "Source")
@Table(name = "source")
public class Source {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sourceId;
	private String sourceDescription;
	private Integer sourceScore;
	private Date timeCreated;
	private Date lastUpdated;
	
	@ManyToMany
	private List<Category> categories;
	
	//Might want to change this to an ENUM later
	private String sourceType;
	//Will add in the ability to store file later
	//private MultipartFile file;
	private String sourceLink;
	

	public Source() {
		super();
		this.timeCreated = new Date();
		this.lastUpdated = new Date();
		this.sourceScore = 0;
	}

	public Source(String sourceDescription) {
		super();
		this.sourceDescription = sourceDescription;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}

	public Integer getSourceScore() {
		return sourceScore;
	}

	public void setSourceScore(Integer sourceScore) {
		this.sourceScore = sourceScore;
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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}


	public String getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((sourceDescription == null) ? 0 : sourceDescription.hashCode());
		result = prime * result + ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((sourceLink == null) ? 0 : sourceLink.hashCode());
		result = prime * result + ((sourceScore == null) ? 0 : sourceScore.hashCode());
		result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
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
		Source other = (Source) obj;
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
		if (sourceDescription == null) {
			if (other.sourceDescription != null)
				return false;
		} else if (!sourceDescription.equals(other.sourceDescription))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceLink == null) {
			if (other.sourceLink != null)
				return false;
		} else if (!sourceLink.equals(other.sourceLink))
			return false;
		if (sourceScore == null) {
			if (other.sourceScore != null)
				return false;
		} else if (!sourceScore.equals(other.sourceScore))
			return false;
		if (sourceType == null) {
			if (other.sourceType != null)
				return false;
		} else if (!sourceType.equals(other.sourceType))
			return false;
		if (timeCreated == null) {
			if (other.timeCreated != null)
				return false;
		} else if (!timeCreated.equals(other.timeCreated))
			return false;
		return true;
	}
}
