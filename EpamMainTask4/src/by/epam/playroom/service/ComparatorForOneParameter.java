package by.epam.playroom.service;

import java.util.Comparator;

import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.ParameterForComparator;

public class ComparatorForOneParameter implements Comparator<Toy>{

	private ParameterForComparator parameter;
	
	public ComparatorForOneParameter(ParameterForComparator parameter) {
		super();
		this.parameter = parameter;
	}
	
	public ParameterForComparator getParameter() {
		return parameter;
	}

	public void setParameter(ParameterForComparator parameter) {
		this.parameter = parameter;
	}

	@Override
	public int compare(Toy toy_1, Toy toy_2) {
		switch(this.parameter) {
			case COST:
				return Double.compare(toy_1.getCost(), toy_2.getCost());
			case TYPE:
				return toy_1.getToyType().name().compareTo(toy_2.getToyType().name());				
			case SIZE:
				return Integer.compare(toy_1.getSize().ordinal(), toy_2.getSize().ordinal());
			case AGE_GROUP:
				return Integer.compare(toy_1.getAgeGroup().ordinal(), toy_2.getAgeGroup().ordinal());
			default:
				throw new EnumConstantNotPresentException(this.parameter.getClass(), this.parameter.name());
		}
	}

}
