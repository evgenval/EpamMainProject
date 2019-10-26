package by.epam.playroom.domain;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public abstract class Toy {

	private ToyTypes toyType;
	private AgeGroupType ageGroup;
	private SizeType size;
	private double cost;
	
	public Toy() {
		
	}
	
	public ToyTypes getToyType() {
		return toyType;
	}

	public void setToyType(ToyTypes toyType) {
		this.toyType = toyType;
	}

	public Toy(ToyTypes toyType, AgeGroupType ageGroup, SizeType size, double cost) {
		this.toyType = toyType;
		this.ageGroup = ageGroup;
		this.size = size;
		this.cost = cost;
	}

	public AgeGroupType getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroupType ageGroup) {
		this.ageGroup = ageGroup;
	}

	public SizeType getSize() {
		return size;
	}

	public void setSize(SizeType size) {
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageGroup == null) ? 0 : ageGroup.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((toyType == null) ? 0 : toyType.hashCode());
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
		Toy other = (Toy) obj;
		if (ageGroup != other.ageGroup)
			return false;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (size != other.size)
			return false;
		if (toyType != other.toyType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Toy [" + (ageGroup != null ? "ageGroup=" + ageGroup + ", " : "")
				+ (size != null ? "size=" + size + ", " : "") + "cost=" + cost + "]";
	}
	
	
}
