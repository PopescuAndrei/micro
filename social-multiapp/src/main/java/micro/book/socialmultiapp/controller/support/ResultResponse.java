package micro.book.socialmultiapp.controller.support;

public class ResultResponse {
	
	private boolean correct;

	public ResultResponse() {
		
	}
	
	public ResultResponse(boolean correct) {
		super();
		this.correct = correct;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}