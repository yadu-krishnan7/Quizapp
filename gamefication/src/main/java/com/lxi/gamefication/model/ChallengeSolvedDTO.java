package com.lxi.gamefication.model;

import lombok.Value;

@Value
public class ChallengeSolvedDTO {
    private long attemptId;
    private boolean correct;
    private long userId;
    private String userAlias;
}
