package com.lxi.gamefication.service;

import org.springframework.stereotype.Service;

import com.lxi.gamefication.model.BadgeCard;
import com.lxi.gamefication.model.BadgeType;
import com.lxi.gamefication.model.ChallengeSolvedDTO;
import com.lxi.gamefication.model.LeaderBoard;
import com.lxi.gamefication.model.Scorecard;
import com.lxi.gamefication.repository.LeaderBoardRepo;

@Service
public class LeaderBoardService {
    
    private final LeaderBoardRepo leaderBoardRepo;

    public LeaderBoardService(LeaderBoardRepo leaderBoardRepo){
        this.leaderBoardRepo = leaderBoardRepo;
    }

    public String saveScore(ChallengeSolvedDTO challengeSolvedDTO){
        LeaderBoard leaderBoard = new LeaderBoard();
        Scorecard scorecard = new Scorecard();
        BadgeCard badgeCard = new BadgeCard();
        badgeCard.setBadgeType(BadgeType.BRONZE);
        leaderBoard.setUserAlias(challengeSolvedDTO.getUserAlias());
        leaderBoard.setScorecard(scorecard);
        leaderBoard.setBadgeCard(badgeCard);

        return leaderBoardRepo.save(leaderBoard).getUserAlias() + "saved";


    }
}
