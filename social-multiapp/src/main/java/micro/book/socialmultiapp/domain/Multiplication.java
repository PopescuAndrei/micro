package micro.book.socialmultiapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static micro.book.socialmultiapp.domain.support.DbNames.ID;
import static micro.book.socialmultiapp.domain.support.DbNames.MULTIPLICATION;
import static micro.book.socialmultiapp.domain.support.DbNames.FACTOR_A;
import static micro.book.socialmultiapp.domain.support.DbNames.FACTOR_B;

/**
 * This class represents a Multiplication (a * b).
 */
@Entity
@Table(name = MULTIPLICATION)
public class Multiplication implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Long id;
	
	// Both factors
	@Column(name = FACTOR_A)
    private final int factorA;
	
	@Column(name = FACTOR_B)
    private final int factorB;

    public Multiplication() {
        this(0, 0);
    }
    
    public Multiplication(int factorA, int factorB) {
    	this.factorA = factorA;
    	this.factorB = factorB;
    }

	public int getFactorA() {
		return factorA;
	}

	public int getFactorB() {
		return factorB;
	}

	public int getMultiplicationResult() {
		return factorA * factorB;
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
		result = prime * result + factorA;
		result = prime * result + factorB;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Multiplication other = (Multiplication) obj;
		if (factorA != other.factorA)
			return false;
		if (factorB != other.factorB)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Multiplication [id=" + id + ", factorA=" + factorA + ", factorB=" + factorB + "]";
	}
}
