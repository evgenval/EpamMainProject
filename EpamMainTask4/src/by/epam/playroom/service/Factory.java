package by.epam.playroom.service;

import by.epam.playroom.domain.Ball;
import by.epam.playroom.domain.Car;
import by.epam.playroom.domain.Cubbe;
import by.epam.playroom.domain.Doll;
import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.BallTypeOfGame;
import by.epam.playroom.domain.enums.CarAppointment;
import by.epam.playroom.domain.enums.ColorType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public class Factory {

	public static Toy createToy(Object... args) {
		if(((ToyTypes) args[0]).equals(ToyTypes.BALL)) {
			return new Ball((AgeGroupType)args[1], (SizeType)args[2], (double)args[3], (BallTypeOfGame)args[4]);
		} else if(((ToyTypes) args[0]).equals(ToyTypes.CAR)) {
			return new Car((AgeGroupType)args[1], (SizeType)args[2], (double)args[3], (CarAppointment)args[4]);
		} else if(((ToyTypes) args[0]).equals(ToyTypes.CUBBE)) {
			return new Cubbe((AgeGroupType)args[1], (SizeType)args[2], (double)args[3], (ColorType)args[4]);
		} else if(((ToyTypes) args[0]).equals(ToyTypes.DOLL)) {
			return new Doll((AgeGroupType)args[1], (SizeType)args[2], (double)args[3], (boolean)args[4]);
		}
		return null;
		
	}
}
