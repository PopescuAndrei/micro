package micro.book.socialmultiapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import micro.book.socialmultiapp.domain.MultiplicationResultAttempt;
import micro.book.socialmultiapp.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

	private final MultiplicationService multService;
	
	@Autowired
	MultiplicationResultAttemptController(final MultiplicationService multService) {
		this.multService = multService;
	}
	
	@GetMapping
	ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
		return ResponseEntity.ok(multService.getStatsForUser(alias));
	}
	
    @GetMapping("/{resultId}")
    ResponseEntity<MultiplicationResultAttempt> getResultById(final @PathVariable("resultId") Long resultId) {
        return ResponseEntity.ok(multService.getResultById(resultId));
    }
    
	@PostMapping
	ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt attempt) {
		boolean isCorrect = multService.checkAttempt(attempt);
		MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(
				attempt.getUser(), attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);
		
		return ResponseEntity.ok(attemptCopy);
	}
	
}
