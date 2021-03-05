package com.robertrice.odinsstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robertrice.odinsstudy.models.Category;
//sets up queries to the data base for Category entities
public interface CategoryRepository extends JpaRepository<Category, String>{

}
