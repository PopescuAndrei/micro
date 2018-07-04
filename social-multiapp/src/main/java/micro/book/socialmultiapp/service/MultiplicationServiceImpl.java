package micro.book.socialmultiapp.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import micro.book.socialmultiapp.domain.Multiplication;
import micro.book.socialmultiapp.domain.MultiplicationResultAttempt;
import micro.book.socialmultiapp.domain.User;
import micro.book.socialmultiapp.event.EventDispatcher;
import micro.book.socialmultiapp.event.MultiplicationSolvedEvent;
import micro.book.socialmultiapp.repository.MultiplicationResultAttemptRepository;
import micro.book.socialmultiapp.repository.UserRepository;

@Service
final class MultiplicationServiceImpl implements MultiplicationService {

    private RandomGeneratorService randomGeneratorService;
    private MultiplicationResultAttemptRepository attemptRepository;
    private UserRepository userRepository;
    private EventDispatcher eventDispatcher;
    
    @Autowired
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
    								 final MultiplicationResultAttemptRepository attemptRepository,
    								 final UserRepository userRepository,
    								 final EventDispatcher eventDispatcher) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    @Transactional
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
    	Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());
        Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as correct!");
    	
    	boolean isCorrect = attempt.getResultAttempt() ==
        								attempt.getMultiplication().getFactorA() *
        								attempt.getMultiplication().getFactorB();
        
    	MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(
    				user.orElse(attempt.getUser()),
    				attempt.getMultiplication(),
    				attempt.getResultAttempt(),
    				isCorrect
    			);
    	
    	attemptRepository.save(checkedAttempt);
    	
    	// communicate the event
    	eventDispatcher.send(new MultiplicationSolvedEvent(checkedAttempt.getId(), checkedAttempt.getUser().getId(), checkedAttempt.isCorrect()));
    	
    	return isCorrect;
    }
    
    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
    	return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }
    

    @Override
    public MultiplicationResultAttempt getResultById(final Long resultId) {
        MultiplicationResultAttempt mra = null;
    	try {
        	mra = attemptRepository.findById(resultId).get();
        } catch (NoSuchElementException e) {
        	// silently ignore it for now
        }
    	
    	return mra;
    }
}