package micro.book.socialmultiapp.domain;

import static micro.book.socialmultiapp.domain.support.DbNames.APP_USER_ID;
import static micro.book.socialmultiapp.domain.support.DbNames.CORRECT;
import static micro.book.socialmultiapp.domain.support.DbNames.ID;
import static micro.book.socialmultiapp.domain.support.DbNames.MULTIPLICATION_ID;
import static micro.book.socialmultiapp.domain.support.DbNames.MULTIPLICATION_RESULT_ATTEMPT;
import static micro.book.socialmultiapp.domain.support.DbNames.RESULT_ATTEMPT;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = MULTIPLICATION_RESULT_ATTEMPT)
public class MultiplicationResultAttempt implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = ID)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = APP_USER_ID)
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = MULTIPLICATION_ID)
	private Multiplication multiplication;
	
	@Column(name = RESULT_ATTEMPT)
	private int resultAttempt;
	
	@Column(name = CORRECT)
	private boolean correct;
	
	public MultiplicationResultAttempt() {
		user = null;
		multiplication = null;
		resultAttempt = -1;
		correct = false;
	}
	

	public MultiplicationResultAttempt(Long id, User user, Multiplication mult, int resultAttempt, boolean correct) {
		this.user = user;
		this.multiplication = mult;
		this.resultAttempt = resultAttempt;
		this.correct = correct;
	}
	
	public MultiplicationResultAttempt(User user, Multiplication mult, int resultAttempt, boolean correct) {
		this(null, user, mult, resultAttempt, correct);
	}

	public User getUser() {
		return user;
	}

	public Multiplication getMultiplication() {
		return multiplication;
	}

	public int getResultAttempt() {
		return resultAttempt;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMultiplication(Multiplication multiplication) {
		this.multiplication = multiplication;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correct ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((multiplication == null) ? 0 : multiplication.hashCode());
		result = prime * result + resultAttempt;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multiplication == null) {
			if (other.multiplication != null)
				return false;
		} else if (!multiplication.equals(other.multiplication))
			return false;
		if (resultAttempt != other.resultAttempt)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MultiplicationResultAttempt [id=" + id + ", user=" + user + ", multiplication=" + multiplication + ", resultAttempt=" + resultAttempt
				+ ", correct=" + correct + "]";
	}
}
