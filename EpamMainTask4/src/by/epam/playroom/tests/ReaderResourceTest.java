package by.epam.playroom.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;
import by.epam.playroom.resources.ReaderResource;
import by.epam.playroom.service.Factory;

public class ReaderResourceTest {

	File file = new File("test1.txt");
	File wrongFile = new File("test1wrong.txt");
	ArrayList<Toy> expectedToys = new ArrayList<Toy>();

	@Test
	void testReadToysFromCorrectFile() {
		ReaderResource reader = new ReaderResource();
		ArrayList<Toy> toys = reader.readFromFile(file);

		expectedToys.add(Factory.createToy(ToyTypes.CUBBE, 3000.2, AgeGroupType.YOUNGERGROUP, SizeType.MEDIUM));
		expectedToys.add(Factory.createToy(ToyTypes.CAR, 300.0, AgeGroupType.OLDERGROUP, SizeType.SMALL));
		assertTrue(toys.equals(expectedToys));
	}

	@Test
	void testReadToysFromWrongFile() {
		ReaderResource reader = new ReaderResource();
		ArrayList<Toy> toys = reader.readFromFile(wrongFile);

		expectedToys.add(Factory.createToy(ToyTypes.CAR, 300.0, AgeGroupType.YOUNGERGROUP, SizeType.BIG));
		assertTrue(toys.equals(expectedToys));
	}
}
