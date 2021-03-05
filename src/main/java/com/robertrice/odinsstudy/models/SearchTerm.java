package com.robertrice.odinsstudy.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
//this table holds search data for the purpose of recommendation
@Entity
public class SearchTerm {
	@Id
	public String searchTerm;
	public Long timesSearched;
	private Date lastSearched;
}
