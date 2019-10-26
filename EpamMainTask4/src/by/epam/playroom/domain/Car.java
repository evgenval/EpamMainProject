package by.epam.playroom.domain;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.CarAppointment;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public class Car extends Toy{
	
	private static final ToyTypes toyType = ToyTypes.CAR;
	private CarAppointment appointment;						//(police, fire engine and etc.)

	public Car() {
		super();
	}
	
	public Car(AgeGroupType ageGroup, SizeType size, double cost, CarAppointment appointment) {
		super(toyType, ageGroup, size, cost);
		this.appointment = appointment;
	}

	public CarAppointment getAppointment() {
		return appointment;
	}

	public void setAppointment(CarAppointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Car [" + (appointment != null ? "appointment=" + appointment : "") + "]";
	}
	
}
