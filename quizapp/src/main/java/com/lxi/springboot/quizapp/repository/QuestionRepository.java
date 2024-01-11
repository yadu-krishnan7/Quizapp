package com.lxi.springboot.quizapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxi.springboot.quizapp.model.Option;
import com.lxi.springboot.quizapp.model.Question;

@Repository
public class QuestionRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public QuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getAllQuestions(){
        String sql = "SELECT * FROM qna";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Question question = new Question();
            question.setQuestion(rs.getString("Question"));
            List<Option> options = new ArrayList<>(); 
             options.add(new Option(rs.getString("OptionA")));
             options.add(new Option(rs.getString("OptionB")));
             options.add(new Option(rs.getString("OptionC")));
            question.setOptions(options);
            return question;
        });
    }

    public String getAnswerForOption(String question) {
        String sql = "SELECT CorrectAnswer FROM qna WHERE Question = ?";
        
        return jdbcTemplate.queryForObject(sql, String.class, question);
    }
    
}
