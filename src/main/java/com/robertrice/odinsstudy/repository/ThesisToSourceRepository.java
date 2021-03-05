package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Source;
import com.robertrice.odinsstudy.models.Thesis;
import com.robertrice.odinsstudy.relationship.ThesisToSourceRelationship;
//sets up queries to the data base for ThesisToSourceRelationship entities
public interface ThesisToSourceRepository extends JpaRepository<ThesisToSourceRelationship, Thesis>{
	Iterable<ThesisToSourceRelationship> findAllByThesisId(Thesis thesis);
	Iterable<ThesisToSourceRelationship> findAllBySourceId(Source source);
}
