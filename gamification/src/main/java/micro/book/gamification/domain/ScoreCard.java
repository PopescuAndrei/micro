package micro.book.gamification.domain;

import static micro.book.gamification.domain.support.DbNames.ATTEMPT_ID;
import static micro.book.gamification.domain.support.DbNames.ID;
import static micro.book.gamification.domain.support.DbNames.SCORE;
import static micro.book.gamification.domain.support.DbNames.SCORE_CARD;
import static micro.book.gamification.domain.support.DbNames.SCORE_TIMESTAMP;
import static micro.book.gamification.domain.support.DbNames.USER_ID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = SCORE_CARD)
public class ScoreCard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final int DEFAULT_SCORE = 10;
	
	@Id
	@GeneratedValue
	@Column(name = ID)
	private Long id;
	
	@Column(name = USER_ID)
	private Long userId;
	
	@Column(name = ATTEMPT_ID)
	private Long attemptId;
	
	@Column(name = SCORE_TIMESTAMP)
	private long scoreTimestamp;
	
	@Column(name = SCORE)
	private int score;
	
	public ScoreCard() {
		this(null, null, null, 0, 0);
	}
	
	public ScoreCard(Long userId, Long attemptId) {
		this(null, userId, attemptId, System.currentTimeMillis(), DEFAULT_SCORE);
	}
	
	public ScoreCard(Long id, Long userId, Long attemptId, long scoreTimestamp, int score) {
		this.id = id;
		this.userId = userId;
		this.attemptId = attemptId;
		this.scoreTimestamp = scoreTimestamp;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(Long attemptId) {
		this.attemptId = attemptId;
	}

	public long getScoreTimestamp() {
		return scoreTimestamp;
	}

	public void setScoreTimestamp(long scoreTimestamp) {
		this.scoreTimestamp = scoreTimestamp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int getDefaultScore() {
		return DEFAULT_SCORE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attemptId == null) ? 0 : attemptId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + score;
		result = prime * result + (int) (scoreTimestamp ^ (scoreTimestamp >>> 32));
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
		ScoreCard other = (ScoreCard) obj;
		if (attemptId == null) {
			if (other.attemptId != null)
				return false;
		} else if (!attemptId.equals(other.attemptId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (score != other.score)
			return false;
		if (scoreTimestamp != other.scoreTimestamp)
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
		return "ScoreCard [id=" + id + ", userId=" + userId + ", attemptId=" + attemptId + ", scoreTimestamp=" + scoreTimestamp + ", score=" + score + "]";
	}
}
