package com.lxi.springboot.quizapp.eventpublisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lxi.springboot.quizapp.events.ChallengeSolvedEvent;
import com.lxi.springboot.quizapp.model.Attempt;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChallengeEventPublisher {
   
    private final AmqpTemplate amqpTemplate;

    @Value("${amqp.exchange.attempts}")
    private final String challengesTopicExchange;


    public void challengeSolved(Attempt attempt){
        String routingKey = "attempt." + (attempt.isCorrect() ?
          "correct" : "wrong");

          amqpTemplate.convertAndSend(challengesTopicExchange,routingKey,new ChallengeSolvedEvent(0, attempt.isCorrect(), attempt.getUser().getUserName()));
    }
}
