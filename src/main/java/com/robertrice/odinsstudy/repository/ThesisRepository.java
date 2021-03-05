package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Thesis;
//sets up queries to the data base for Thesis entities
public interface ThesisRepository extends JpaRepository<Thesis, Long>{

}
