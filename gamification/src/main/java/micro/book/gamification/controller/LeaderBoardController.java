package micro.book.gamification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import micro.book.gamification.domain.support.LeaderBoardRow;
import micro.book.gamification.service.LeaderBoardService;

@RestController
@RequestMapping("/leaders")
public final class LeaderBoardController {

	private final LeaderBoardService leaderBoardService;
	
	public LeaderBoardController(final LeaderBoardService leaderBoardService) {
		this.leaderBoardService = leaderBoardService;
	}
	
	@GetMapping
	public List<LeaderBoardRow> getLeaderBoard() {
		return leaderBoardService.getCurrentLeaderBoard();
	}
}
