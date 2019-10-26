package by.epam.playroom.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import by.epam.playroom.domain.Room;
import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.ParameterForComparator;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;
import by.epam.playroom.service.Factory;

public class RoomTest {

	ArrayList<Toy> toys = new ArrayList<Toy>();
	ArrayList<Toy> toysExpected = new ArrayList<Toy>();
	Room room = new Room();

	Toy doll40YBig = Factory.createToy(ToyTypes.DOLL, 40.0, AgeGroupType.YOUNGERGROUP, SizeType.BIG);
	Toy ball11YSmall = Factory.createToy(ToyTypes.BALL, 11.2, AgeGroupType.YOUNGERGROUP, SizeType.SMALL);
	Toy car200OMeduim = Factory.createToy(ToyTypes.CAR, 200.4, AgeGroupType.OLDERGROUP, SizeType.MEDIUM);
	Toy cubbe4MSmall = Factory.createToy(ToyTypes.CUBBE, 4.0, AgeGroupType.MEDIUMGROUP, SizeType.SMALL);
	Toy car500YMedium = Factory.createToy(ToyTypes.CAR, 500.0, AgeGroupType.YOUNGERGROUP, SizeType.MEDIUM);
	Toy ball30OBig = Factory.createToy(ToyTypes.BALL, 30.3, AgeGroupType.OLDERGROUP, SizeType.BIG);

	void createToysArray() {
		toys.add(doll40YBig);
		toys.add(ball11YSmall);
		toys.add(car200OMeduim);
		toys.add(cubbe4MSmall);
		toys.add(car500YMedium);
		toys.add(ball30OBig);
	}

	@Test
	void testCreateRoom() {
		createToysArray();
		toysExpected.add(ball11YSmall);
		toysExpected.add(doll40YBig);
		toysExpected.add(car500YMedium);

		room.createRoom(3, 200.0, toys);
		assertEquals(toysExpected, room.getRoomToys());
		assertTrue(toysExpected.size() == room.getRoomToys().size());
	}

	@Test
	void testSortToys() {
		createToysArray();
		toysExpected.add(ball11YSmall);
		toysExpected.add(doll40YBig);
		toysExpected.add(car500YMedium);

		room.createRoom(3, 200.0, toys);
		room.sortToys(ParameterForComparator.SIZE);
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testSortToysByPriceAndSize() {
		createToysArray();
		toysExpected.add(ball11YSmall);
		toysExpected.add(doll40YBig);
		toysExpected.add(car500YMedium);

		room.createRoom(3, 200.0, toys);
		room.sortToysByPriceAndAgeGroup();
		assertTrue(toysExpected.equals(room.getRoomToys()));
	}

	@Test
	void testFindToyByPrice() {
		createToysArray();
		Toy toyExpected = ball11YSmall;
		room.createRoom(3, 200.0, toys);
		assertTrue(toyExpected.equals(room.findToyByPrice(11.2)));
	}

	@Test
	void testFindToyByType() {
		createToysArray();
		Toy toyExpected = car500YMedium;
		room.createRoom(3, 200.0, toys);
		assertTrue(toyExpected.equals(room.findToyByType(ToyTypes.CAR)));
	}
}
