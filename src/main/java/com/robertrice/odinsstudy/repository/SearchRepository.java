package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.SearchTerm;
//sets up queries to the data base for SearchTerm entities
public interface SearchRepository extends JpaRepository<SearchTerm, String>{

}
