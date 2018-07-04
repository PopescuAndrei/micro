package micro.book.gamification.domain.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStats implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long userId;
	private int score;
	private List<Badge> badges;

	public GameStats() {
		this(0L, 0, new ArrayList<>());
	}
	
	public GameStats(Long userId, int score, List<Badge> badges) {
		this.userId = userId;
		this.score = score;
		this.badges = badges;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((badges == null) ? 0 : badges.hashCode());
		result = prime * result + score;
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
		GameStats other = (GameStats) obj;
		if (badges == null) {
			if (other.badges != null)
				return false;
		} else if (!badges.equals(other.badges))
			return false;
		if (score != other.score)
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
		return "GameStats [userId=" + userId + ", score=" + score + ", badges=" + badges + "]";
	}

	/**
     * Factory method to build an empty instance (zero points and no badges)
     * @param userId the user's id
     * @return a {@link GameStats} object with zero score and no badges
     */
    public static GameStats emptyStats(final Long userId) {
        return new GameStats(userId, 0, Collections.emptyList());
    }

    /**
     * @return an unmodifiable view of the badge cards list
     */
    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }
}