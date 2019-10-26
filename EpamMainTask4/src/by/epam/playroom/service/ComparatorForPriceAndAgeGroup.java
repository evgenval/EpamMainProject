package by.epam.playroom.service;

import java.util.Comparator;
import by.epam.playroom.domain.Toy;

public class ComparatorForPriceAndAgeGroup implements Comparator<Toy>{

	@Override
	public int compare(Toy toy_1, Toy toy_2) {
		if(Double.compare(toy_1.getCost(), toy_2.getCost()) == 0) {
			return toy_1.getAgeGroup().name().compareTo(toy_2.getAgeGroup().name());
		} else {
			return Double.compare(toy_1.getCost(), toy_2.getCost());
		}
	}

}
