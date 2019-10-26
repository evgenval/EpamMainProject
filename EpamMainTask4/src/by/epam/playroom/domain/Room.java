package by.epam.playroom.domain;

import java.util.ArrayList;
import java.util.Collections;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.BallTypeOfGame;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;
import by.epam.playroom.service.ComparatorForOneParameter;
import by.epam.playroom.service.ComparatorForPriceAndAgeGroup;
import by.epam.playroom.service.Factory;
import by.epam.playroom.domain.enums.ParameterForComparator;;

public class Room{

	private ArrayList<Toy> roomToys = new ArrayList<Toy>();
	private int roomCapacity;
	private double amountOfMoney;
	
	private int getRoomCapacity() {
		return roomCapacity;
	}

	private void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	private double getAmountOfMoney() {
		return amountOfMoney;
	}

	private void setAmountOfMoney(double amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public ArrayList<Toy> getRoomToys() {
		return roomToys;
	}
	
	private void setRoomToys(ArrayList<Toy> roomToys) {
		this.roomToys = roomToys;
	}

	public ArrayList<Toy> createRoom(int roomCapacity, double totalCost, ArrayList<Toy> toys) {
		double priceOfToys = 0.0;
		int counter = 0;

		setAmountOfMoney(totalCost);
		setRoomCapacity(roomCapacity);
		for (Toy toy : toys) {
			if (totalCost > priceOfToys && roomCapacity > counter) {
				this.roomToys.add(toy);
				priceOfToys += toy.getCost();
				counter++;
			}
		}
		setRoomToys(roomToys);
		return roomToys;
	}

	public void sortToys(ParameterForComparator parameter) {
		ComparatorForOneParameter comparator = new ComparatorForOneParameter(parameter);
		Collections.sort(this.roomToys, comparator);
		
	}

	public void sortToysByPriceAndAgeGroup() {
		ComparatorForPriceAndAgeGroup comparator = new ComparatorForPriceAndAgeGroup();
		Collections.sort(this.roomToys, comparator);
		
	}

	public Toy findToyByPrice(double price) {
		Toy toy = Factory.createToy(ToyTypes.BALL, AgeGroupType.MEDIUMGROUP, SizeType.BIG, price, BallTypeOfGame.HOCKEY);
		ComparatorForOneParameter compare = new ComparatorForOneParameter(ParameterForComparator.COST);
		for (Toy toyFromRoom : this.roomToys) {
			if (compare.compare(toyFromRoom, toy) == 0) {
				System.out.println("You are looking for: " + toyFromRoom);
				return toyFromRoom;
			}
		}
		System.out.println("There is no such toys...");
		return null;
	}

	public Toy findToyByType(ToyTypes type) {
		ComparatorForOneParameter compare = new ComparatorForOneParameter(ParameterForComparator.TYPE);
		Toy toy = Factory.createToy(type, AgeGroupType.MEDIUMGROUP, SizeType.BIG, 5.0, null);
		for (Toy toyFromRoom : this.roomToys) {
			if (compare.compare(toyFromRoom, toy) == 0) {
				System.out.println("You are looking for: " + toyFromRoom);
				return toyFromRoom;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return "Room [" + (roomToys != null ? "roomToys=" + getRoomToys() + ", " : "") + "roomCapacity=" + getRoomCapacity()
				+ ", amountOfMoney=" + getAmountOfMoney() + "]";
	}
	
}
