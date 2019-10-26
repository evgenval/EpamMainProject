package by.epam.playroom.service;

import java.io.File;
import java.util.ArrayList;

import by.epam.playroom.resources.ReaderResource;
import by.epam.playroom.domain.Room;
import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.ParameterForComparator;
import by.epam.playroom.domain.enums.ToyTypes;

public class Main {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Acer\\eclipse-workspace\\EpamMainTask4\\src\\by\\epam\\playroom\\resources\\text.txt");

//		File wrong = new File("C:\\Users\\Acer\\eclipse-workspace\\EpamMainTask4\\src\\by\\epam\\playroom\\resources\\wrong.txt");
		ReaderResource reader = new ReaderResource();
		ArrayList<Toy> toys = reader.readFromFile(file);

		Room room_1 = new Room();
		room_1.createRoom(12, 10000.0, toys);
		System.out.println(room_1.toString());
		/*room_1.findToyByPrice(120.3);
		room_1.findToyByType(ToyTypes.CUBBE);
		room_1.sortToys(ParameterForComparator.COST);
		room_1.sortToys(ParameterForComparator.SIZE);
		room_1.sortToys(ParameterForComparator.TYPE);
		room_1.sortToysByPriceAndAgeGroup();*/
	}

}
