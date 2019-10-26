package by.epam.playroom.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.epam.playroom.domain.Toy;
import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.BallTypeOfGame;
import by.epam.playroom.domain.enums.CarAppointment;
import by.epam.playroom.domain.enums.ColorType;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;
import by.epam.playroom.service.Factory;

public class ReaderResource {

	private String line;
	
	private Pattern ball = Pattern.compile("^[Bb]all");
	private Pattern doll = Pattern.compile("^[Dd]oll");
	private Pattern car = Pattern.compile("^[Cc]ar");
	private Pattern cubbe = Pattern.compile("^[Cc]ubbe");
	private Pattern cost = Pattern.compile("(?<=cost\\:\\s)*\\d+[\\\\.]*\\d+");
	private Pattern ageGroupType = 
			Pattern.compile("(?<=ageGroup\\:\\s)?(YOUNGERGROUP|MEDIUMGROUP|OLDERGROUP)");
	private Pattern sizeType = Pattern.compile("(?<=size\\:\\s)(BIG|MEDIUM|SMALL)");
	private Pattern song = Pattern.compile("(?<=song\\:\\s)(true|false)");
	private Pattern carAppointment = Pattern.compile("(?<=appointment\\:\\s)(POLICE|AMBULANCE|FIREENGINE|CIVIL)");
	private Pattern ballTypeOfGame =
			Pattern.compile("(?<=ballGame\\:\\s)(FOOTBALL|BASKETBALL|VOLLEYBALL|HANDBALL|TENNIS|HOCKEY|RUGBY|WATERPOLO)");
	private Pattern colorOfCube = Pattern.compile("(?<=color\\:\\s)(RED|BLUE|WHITE|DARK|PINK|GREEN)");
	
	public ArrayList<Toy> readFromFile(File file){
		ArrayList<Toy> toys = new ArrayList<Toy>();
		BufferedReader bufRead;
		
		try {
			FileReader fileRead = new FileReader(file);
			bufRead = new BufferedReader(fileRead);
			
			while((line = bufRead.readLine()) != null) {
				double costOfToy = 0;
				AgeGroupType ageGroup = null;
				SizeType size = null;
				ToyTypes toyType = null;
				boolean songDoll = false;
				CarAppointment appointment = null;
				BallTypeOfGame ballGame = null;
				ColorType colorCube = null;
				
				Matcher matcherCost = cost.matcher(line);
				if(matcherCost.find()) {
					costOfToy = Double.parseDouble(matcherCost.group());
				}
				Matcher matcherAgeGroup = ageGroupType.matcher(line);
				Matcher matcherSize = sizeType.matcher(line);
				
				try {
					if(matcherAgeGroup.find()) {
						ageGroup = AgeGroupType.valueOf(matcherAgeGroup.group());
					}
					if(matcherSize.find()) {
						size = SizeType.valueOf(matcherSize.group());
					}
				} catch(IllegalArgumentException e) {
					ageGroup = null;
					size = null;
				}
				
				Matcher matcherBall = ball.matcher(line);
				if(matcherBall.find()) {
					toyType = ToyTypes.BALL;
					Matcher matcherBallGame = ballTypeOfGame.matcher(line);
					if(matcherBallGame.find()) {
						ballGame = BallTypeOfGame.valueOf(matcherBallGame.group());
					}
				}
				
				Matcher matcherDoll = doll.matcher(line);
				if(matcherDoll.find()) {
					toyType = ToyTypes.DOLL;
					Matcher matcherDollSong = song.matcher(line);
					if(matcherDollSong.find()) {
						songDoll = Boolean.valueOf(matcherDollSong.group());
					}
				}
				
				Matcher matcherCar = car.matcher(line);
				if(matcherCar.find()) {
					toyType = ToyTypes.CAR;
					Matcher matcherCarAppointment = carAppointment.matcher(line);
					if(matcherCarAppointment.find()) {
						appointment = CarAppointment.valueOf(matcherCarAppointment.group());
					}
				}
				
				Matcher matcherCubbe = cubbe.matcher(line);
				if(matcherCubbe.find()) {
					toyType = ToyTypes.CUBBE;
					Matcher matcherCubeColor = colorOfCube.matcher(line);
					if(matcherCubeColor.find()) {
						colorCube = ColorType.valueOf(matcherCubeColor.group());
					}
				}
				
				if(costOfToy != 0 && ageGroup != null && size != null && toyType != null) {
					if(toyType == ToyTypes.BALL) {
						Toy toy = Factory.createToy(toyType, ageGroup, size, costOfToy, ballGame);
						toys.add(toy);
					} else if(toyType == ToyTypes.CAR) {
						Toy toy = Factory.createToy(toyType, ageGroup, size, costOfToy, appointment);
						toys.add(toy);
					} else if(toyType == ToyTypes.CUBBE) {
						Toy toy = Factory.createToy(toyType, ageGroup, size, costOfToy, colorCube);
						toys.add(toy);
					} else if(toyType == ToyTypes.DOLL) {
						Toy toy = Factory.createToy(toyType, ageGroup, size, costOfToy, songDoll);
						toys.add(toy);
					}
					
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return toys;
	}
}
