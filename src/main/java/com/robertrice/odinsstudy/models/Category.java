package com.robertrice.odinsstudy.models;


import javax.persistence.Entity;
import javax.persistence.Id;

//This table will be used to keep track of user created tags to recommend content.
@Entity
public class Category {
	@Id
	private String category;
	private Long numberOfPosts;
	private Long numberOfInterestedUsers;
}
