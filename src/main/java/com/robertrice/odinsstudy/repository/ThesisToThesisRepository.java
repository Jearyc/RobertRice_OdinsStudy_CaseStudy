package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Thesis;
import com.robertrice.odinsstudy.relationship.ThesisToThesisRelationship;
//sets up queries to the data base for ThesisToThesisRelationship entities
public interface ThesisToThesisRepository extends JpaRepository<ThesisToThesisRelationship, Thesis>{
	Iterable<ThesisToThesisRelationship> findAllByThesisIdOneOrThesisIdTwo(Thesis thesis1, Thesis thesis2);
}
