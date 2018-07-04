package micro.book.gamification.domain;

import static micro.book.gamification.domain.support.DbNames.BADGE;
import static micro.book.gamification.domain.support.DbNames.BADGE_CARD;
import static micro.book.gamification.domain.support.DbNames.BADGE_TIMESTAMP;
import static micro.book.gamification.domain.support.DbNames.ID;
import static micro.book.gamification.domain.support.DbNames.USER_ID;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import micro.book.gamification.domain.support.Badge;

@Entity
@Table(name = BADGE_CARD)
public class BadgeCard implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Long id;
	
	@Column(name = USER_ID)
	private Long userId;
	
	@Column(name = BADGE_TIMESTAMP)
	private long badgeTimestamp;
	
	@Column(name = BADGE)
	private Badge badge;
	
	public BadgeCard() {
		this(null, null, 0, null);
	}
	
	public BadgeCard(Long userId, Badge badge) {
		this(null, userId, System.currentTimeMillis(), badge);
	}
	
	public BadgeCard(Long id, Long userId, long badgeTimestamp, Badge badge) {
		this.id = id;
		this.userId = userId;
		this.badgeTimestamp = badgeTimestamp;
		this.badge = badge;
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

	public long getBadgeTimestamp() {
		return badgeTimestamp;
	}

	public void setBadgeTimestamp(long badgeTimestamp) {
		this.badgeTimestamp = badgeTimestamp;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((badge == null) ? 0 : badge.hashCode());
		result = prime * result + (int) (badgeTimestamp ^ (badgeTimestamp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BadgeCard other = (BadgeCard) obj;
		if (badge != other.badge)
			return false;
		if (badgeTimestamp != other.badgeTimestamp)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "BadgeCard [id=" + id + ", userId=" + userId + ", badgeTimestamp=" + badgeTimestamp + ", badge=" + badge + "]";
	}
}
