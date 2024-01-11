package com.lxi.springboot.quizapp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lxi.springboot.quizapp.exception.UserNotFoundException;
import com.lxi.springboot.quizapp.model.Attempt;
import com.lxi.springboot.quizapp.model.AttemptDTO;
import com.lxi.springboot.quizapp.model.Question;
import com.lxi.springboot.quizapp.model.User;
import com.lxi.springboot.quizapp.repository.AttemptRepository;
import com.lxi.springboot.quizapp.repository.QuestionRepository;
import com.lxi.springboot.quizapp.repository.UserRepository;

@Service
public class AttemptService {
    

    private final QuestionRepository questionRepo;
    private final UserRepository userRepository;

    private static final Long attempts = 0L;

    private final AttemptRepository attemptRepository;
    
    public AttemptService(QuestionRepository questionRepo,UserRepository userRepository,AttemptRepository attemptRepository){
        this.questionRepo = questionRepo;
        this.userRepository = userRepository;
        this.attemptRepository = attemptRepository;
    }   

     public List<Question> getAllQuestions(){
         
        return questionRepo.getAllQuestions();

    }

    public String attempts(AttemptDTO attemptDTO){
        

        if(!userRepository.existsByUserName(attemptDTO.user())){
            throw new UserNotFoundException("User not found");
        }
        String answer = questionRepo.getAnswerForOption(attemptDTO.question());
        if(answer.equals(attemptDTO.answer())){
            Optional<User> userOptional = userRepository.findByUserName(attemptDTO.user());
            User user = userOptional.get();
            Attempt attempt = new Attempt();
            attempt.setAttempts(attempts + 1L);
            attempt.setCorrect(true);
            attempt.setUser(user);

            user.setRanks(user.getRanks()+10);

            userRepository.save(user);
            
            attemptRepository.save(attempt);
            

            return "Answer is correct";
        }else{
            return "Wrong answer";
        }
    }

    
}
