package com.robertrice.odinsstudy;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.robertrice.odinsstudy.models.Source;
import com.robertrice.odinsstudy.models.Thesis;
import com.robertrice.odinsstudy.repository.SourceRepository;
import com.robertrice.odinsstudy.repository.SourceToSourceRepository;
import com.robertrice.odinsstudy.repository.ThesisRepository;
import com.robertrice.odinsstudy.repository.ThesisToSourceRepository;
import com.robertrice.odinsstudy.repository.ThesisToThesisRepository;
import com.robertrice.odinsstudy.repository.UserRepository;

//this is a set of junit tests for my application
@SpringBootTest
class RobertRiceOdinsStudyCaseStudyApplicationTests {
	// repository set up
	private UserRepository userRepository;
	private ThesisRepository thesisRepository;
	private SourceRepository sourceRepository;
	private ThesisToSourceRepository tsRepository;
	private ThesisToThesisRepository ttRepository;
	private SourceToSourceRepository ssRepository;
	@Autowired
	void getApplicationRepositories(UserRepository userRepository, ThesisToSourceRepository tsRepository, 
			ThesisRepository thesisRepository, SourceRepository sourceRepository, ThesisToThesisRepository ttRepository, SourceToSourceRepository ssRepository) {
		this.userRepository=userRepository;
		this.tsRepository=tsRepository;
		this.thesisRepository=thesisRepository;
		this.sourceRepository=sourceRepository;
		this.ttRepository=ttRepository;
		this.ssRepository=ssRepository;
	}
	//tests that the application loads
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	//Parameterized Test (assumes my test user exists)
	@ParameterizedTest
	@CsvSource({"user,true", " ,false"})
	void testUserRepositoryByName(String username, Boolean veracity) {
		if (veracity) {
			assertNotNull(userRepository.findByUsername(username));
		}else {
			assertNull(userRepository.findByUsername(username));
		}
	}
	
	//checks that the database table connection for thesis to thesis works
	@Test
	void testTsRepositoryBySource() {
		assertNotNull(tsRepository.findAllBySourceId(sourceRepository.getOne(1L)));
	}
	
	//checks that the database table connection for thesis to source works
	@Test
	void testTsRepositoryByThesis() {
		assertNotNull(tsRepository.findAllByThesisId(thesisRepository.getOne(1L)));
	}
	
	//checks that the database table connection for thesis to thesis works
	@Test
	void testTtRepositoryByThesis() {
		Thesis thesis = thesisRepository.getOne(1L);
		assertNotNull(ttRepository.findAllByThesisIdOneOrThesisIdTwo(thesis, thesis));
	}
	
	//checks that the database table connection for source to source works
	@Test
	void testSsRepositoryBySource() {
		Source source = sourceRepository.getOne(1L);
		assertNotNull(ssRepository.findAllBySourceIdOneOrSourceIdTwo(source, source));
	}

}
