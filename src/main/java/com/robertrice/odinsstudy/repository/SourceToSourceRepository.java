package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Source;
import com.robertrice.odinsstudy.relationship.SourceToSourceRelationship;
//sets up queries to the data base for SourceToSourceRelationship entities
public interface SourceToSourceRepository extends JpaRepository<SourceToSourceRelationship, Source>{
	Iterable<SourceToSourceRelationship> findAllBySourceIdOneOrSourceIdTwo(Source source1, Source source2);
}
