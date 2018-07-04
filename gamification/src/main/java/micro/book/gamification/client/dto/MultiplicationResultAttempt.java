package micro.book.gamification.client.dto;

import java.io.Serializable;

public class MultiplicationResultAttempt implements Serializable{

	private static final long serialVersionUID = 1L;

	private String userAlias;
	private int multiplicationFactorA;
	private int multiplicationFactorB;
	private int resultAttempt;
	
	private boolean correct;

	public MultiplicationResultAttempt() {
		this(null, -1, -1, -1, false);
	}
	
	public MultiplicationResultAttempt(String userAlias, int factorA, int factorB, int resultAttempt, boolean correct) {
		this.userAlias = userAlias;
		this.multiplicationFactorA = factorA;
		this.multiplicationFactorB = factorB;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}
	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public int getMultiplicationFactorA() {
		return multiplicationFactorA;
	}

	public void setMultiplicationFactorA(int multiplicationFactorA) {
		this.multiplicationFactorA = multiplicationFactorA;
	}

	public int getMultiplicationFactorB() {
		return multiplicationFactorB;
	}

	public void setMultiplicationFactorB(int multiplicationFactorB) {
		this.multiplicationFactorB = multiplicationFactorB;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public void setResultAttempt(int resultAttempt) {
		this.resultAttempt = resultAttempt;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correct ? 1231 : 1237);
		result = prime * result + multiplicationFactorA;
		result = prime * result + multiplicationFactorB;
		result = prime * result + resultAttempt;
		result = prime * result + ((userAlias == null) ? 0 : userAlias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultiplicationResultAttempt other = (MultiplicationResultAttempt) obj;
		if (correct != other.correct)
			return false;
		if (multiplicationFactorA != other.multiplicationFactorA)
			return false;
		if (multiplicationFactorB != other.multiplicationFactorB)
			return false;
		if (resultAttempt != other.resultAttempt)
			return false;
		if (userAlias == null) {
			if (other.userAlias != null)
				return false;
		} else if (!userAlias.equals(other.userAlias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MultiplicationResultAttempt [userAlias=" + userAlias + ", multiplicationFactorA=" + multiplicationFactorA + ", multiplicationFactorB="
				+ multiplicationFactorB + ", resultAttempt=" + resultAttempt + ", correct=" + correct + "]";
	}
}
