package micro.book.gamification.service;

import java.util.List;

import org.springframework.stereotype.Service;

import micro.book.gamification.domain.repository.ScoreCardRepository;
import micro.book.gamification.domain.support.LeaderBoardRow;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private ScoreCardRepository scoreCardRepository;

    LeaderBoardServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        return scoreCardRepository.findFirst10();
    }
}