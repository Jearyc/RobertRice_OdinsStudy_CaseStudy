package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Source;
//sets up queries to the data base for source entities
public interface SourceRepository extends JpaRepository<Source, Long>{

}
