package com.lxi.springboot.quizapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lxi.springboot.quizapp.model.Answer;

public interface AnswrRepository {
    
    @Query("SELECT a.* FROM Answer a LEFT JOIN questions q ON a.questions_id = q.id WHERE q.question = :questionText")
    Answer findAnswerUsingQuestion(@Param("questionText") String questionText);
}
