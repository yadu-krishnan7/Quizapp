package com.lxi.springboot.quizapp.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lxi.springboot.quizapp.eventpublisher.ChallengeEventPublisher;
import com.lxi.springboot.quizapp.exception.UserNotFoundException;
import com.lxi.springboot.quizapp.model.Answer;
import com.lxi.springboot.quizapp.model.Attempt;
import com.lxi.springboot.quizapp.model.AttemptDTO;
import com.lxi.springboot.quizapp.model.Question;
import com.lxi.springboot.quizapp.model.User;
import com.lxi.springboot.quizapp.repository.AnswrRepository;
import com.lxi.springboot.quizapp.repository.AttemptRepository;
import com.lxi.springboot.quizapp.repository.QuestionRepository;
import com.lxi.springboot.quizapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttemptService {
    

    private final QuestionRepository questionRepo;
    private final UserRepository userRepository;
    private final AnswrRepository answerRepository;
    private final ChallengeEventPublisher challengeEventPublisher;

    private final AttemptRepository attemptRepository;
    
      

     public List<Question> getAllQuestions(){
         
        return questionRepo.findAllQuestionsWithOptions();

    }

    public String attempts(AttemptDTO attemptDTO){
        

        if(!userRepository.existsByUserName(attemptDTO.user())){
            throw new UserNotFoundException("User not found");
        }
        Answer answer = answerRepository.findAnswerUsingQuestion(attemptDTO.question());
        if(answer.getAnswer().equals(attemptDTO.answer())){
            Optional<User> userOptional = userRepository.findByUserName(attemptDTO.user());
            User user = userOptional.get();
            Attempt attempt = new Attempt();
            attempt.setCorrect(true);
            attempt.setUser(user);


            userRepository.save(user);
            
            attemptRepository.save(attempt);
            
            challengeEventPublisher.challengeSolved(attempt);

            

            return "Answer is correct";
        }else{
            return "Wrong answer";
        }
    }

    
}
