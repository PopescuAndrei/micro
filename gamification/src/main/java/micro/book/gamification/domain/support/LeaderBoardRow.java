package micro.book.gamification.domain.support;

import java.io.Serializable;

public class LeaderBoardRow implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long totalScore;
	
	public LeaderBoardRow() {
		this(0L, 0L);
	}
	
	public LeaderBoardRow(Long userId, Long totalScore) {
		this.userId = userId;
		this.totalScore = totalScore;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((totalScore == null) ? 0 : totalScore.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		LeaderBoardRow other = (LeaderBoardRow) obj;
		if (totalScore == null) {
			if (other.totalScore != null)
				return false;
		} else if (!totalScore.equals(other.totalScore))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LeaderBoardRow [userId=" + userId + ", totalScore=" + totalScore + "]";
	}
}
