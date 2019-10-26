package by.epam.playroom.domain;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.ColorType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public class Cubbe extends Toy{
	
	private static final ToyTypes toyType = ToyTypes.CUBBE;
	private ColorType color;

	public Cubbe() {
		super();
	}
	
	public Cubbe(AgeGroupType ageGroup, SizeType size, double cost, ColorType color) {
		super(toyType, ageGroup, size, cost);
		this.color = color;
	}

	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Cubbe [" + (color != null ? "color=" + color : "") + "]";
	}
	
	
}
