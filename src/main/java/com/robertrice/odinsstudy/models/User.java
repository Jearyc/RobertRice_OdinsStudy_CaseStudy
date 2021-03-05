package com.robertrice.odinsstudy.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import com.robertrice.odinsstudy.annotations.EmailConstraint;

//This table stores the data on users.
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique = true)
	private String username;
	private String password;
	@EmailConstraint
	private String email;
	private String userRole;
	private Integer userTrustworthiness;
	
	@ManyToMany
	List<Category> userInterest;
	
	@OneToMany
	List<Thesis> pinnedThesis;
	
	@OneToMany
	List<Source> pinnedSource;
	
	@OneToMany
	List<Thesis> favoriteThesis;
	
	@OneToMany
	List<Source> favoriteSource;
	
	@OneToMany
	List<Thesis> userThesis;
	
	@OneToMany
	List<Source> userSource;
	
	public User() {
		this.userRole = "ROLE_USER";
		this.userTrustworthiness = 0;
	}

	public User(String username, String password, String email) {
		this();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getUserTrustworthiness() {
		return userTrustworthiness;
	}

	public void setUserTrustworthiness(Integer userTrustworthiness) {
		this.userTrustworthiness = userTrustworthiness;
	}

	public List<Category> getUserInterest() {
		return userInterest;
	}

	public void setUserInterest(List<Category> userInterest) {
		this.userInterest = userInterest;
	}

	public List<Thesis> getPinnedThesis() {
		return pinnedThesis;
	}

	public void setPinnedThesis(List<Thesis> pinnedThesis) {
		this.pinnedThesis = pinnedThesis;
	}

	public List<Source> getPinnedSource() {
		return pinnedSource;
	}

	public void setPinnedSource(List<Source> pinnedSource) {
		this.pinnedSource = pinnedSource;
	}

	public List<Thesis> getFavoriteThesis() {
		return favoriteThesis;
	}

	public void setFavoriteThesis(List<Thesis> favoriteThesis) {
		this.favoriteThesis = favoriteThesis;
	}

	public List<Source> getFavoriteSource() {
		return favoriteSource;
	}

	public void setFavoriteSource(List<Source> favoriteSource) {
		this.favoriteSource = favoriteSource;
	}

	public List<Thesis> getUserThesis() {
		return userThesis;
	}

	public void setUserThesis(List<Thesis> userThesis) {
		this.userThesis = userThesis;
	}

	public List<Source> getUserSource() {
		return userSource;
	}

	public void setUserSource(List<Source> userSource) {
		this.userSource = userSource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favoriteSource == null) ? 0 : favoriteSource.hashCode());
		result = prime * result + ((favoriteThesis == null) ? 0 : favoriteThesis.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pinnedSource == null) ? 0 : pinnedSource.hashCode());
		result = prime * result + ((pinnedThesis == null) ? 0 : pinnedThesis.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userInterest == null) ? 0 : userInterest.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((userSource == null) ? 0 : userSource.hashCode());
		result = prime * result + ((userThesis == null) ? 0 : userThesis.hashCode());
		result = prime * result + ((userTrustworthiness == null) ? 0 : userTrustworthiness.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favoriteSource == null) {
			if (other.favoriteSource != null)
				return false;
		} else if (!favoriteSource.equals(other.favoriteSource))
			return false;
		if (favoriteThesis == null) {
			if (other.favoriteThesis != null)
				return false;
		} else if (!favoriteThesis.equals(other.favoriteThesis))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pinnedSource == null) {
			if (other.pinnedSource != null)
				return false;
		} else if (!pinnedSource.equals(other.pinnedSource))
			return false;
		if (pinnedThesis == null) {
			if (other.pinnedThesis != null)
				return false;
		} else if (!pinnedThesis.equals(other.pinnedThesis))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userInterest == null) {
			if (other.userInterest != null)
				return false;
		} else if (!userInterest.equals(other.userInterest))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userSource == null) {
			if (other.userSource != null)
				return false;
		} else if (!userSource.equals(other.userSource))
			return false;
		if (userThesis == null) {
			if (other.userThesis != null)
				return false;
		} else if (!userThesis.equals(other.userThesis))
			return false;
		if (userTrustworthiness == null) {
			if (other.userTrustworthiness != null)
				return false;
		} else if (!userTrustworthiness.equals(other.userTrustworthiness))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
