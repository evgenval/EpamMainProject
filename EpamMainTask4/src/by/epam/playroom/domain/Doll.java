package by.epam.playroom.domain;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public class Doll extends Toy{
	
	private static final ToyTypes toyType = ToyTypes.DOLL;
	private boolean canSingTheSong;

	public Doll() {
		super();
	}
	
	public Doll(AgeGroupType ageGroup, SizeType size, double cost, boolean singSong) {
		super(toyType, ageGroup, size, cost);
		this.canSingTheSong = singSong;
	}

	public boolean isCanSingTheSong() {
		return canSingTheSong;
	}

	public void setCanSingTheSong(boolean canSingTheSong) {
		this.canSingTheSong = canSingTheSong;
	}

	@Override
	public String toString() {
		return "Doll [canSingTheSong=" + canSingTheSong + "]";
	}
	
	
}
