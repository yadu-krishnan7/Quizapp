package com.lxi.springboot.quizapp.model;

import java.util.List;

import lombok.Data;

@Data
public class QuestionDTO {
  
    private Long id;
    private String questionText;
    private List<Option> options;
}
