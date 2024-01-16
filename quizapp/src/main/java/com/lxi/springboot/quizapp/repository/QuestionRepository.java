package com.lxi.springboot.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lxi.springboot.quizapp.model.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

    
    @Query("SELECT DISTINCT q FROM Question q LEFT JOIN q.options o")
    List<Question> findAllQuestionsWithOptions();
   
}
