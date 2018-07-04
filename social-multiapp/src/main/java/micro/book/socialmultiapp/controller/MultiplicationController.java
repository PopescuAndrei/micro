package micro.book.socialmultiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import micro.book.socialmultiapp.domain.Multiplication;
import micro.book.socialmultiapp.service.MultiplicationService;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

	private final MultiplicationService multService;
	
	@Autowired
	public MultiplicationController(final MultiplicationService multService) {
		this.multService = multService;
	}
	
	@GetMapping("/random")
	Multiplication getRandomMultiplication() {
		return multService.createRandomMultiplication();
	}
}
