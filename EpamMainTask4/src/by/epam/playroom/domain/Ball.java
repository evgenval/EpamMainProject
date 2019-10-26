package by.epam.playroom.domain;

import by.epam.playroom.domain.enums.AgeGroupType;
import by.epam.playroom.domain.enums.BallTypeOfGame;
import by.epam.playroom.domain.enums.SizeType;
import by.epam.playroom.domain.enums.ToyTypes;

public class Ball extends Toy{
	
	private static final ToyTypes toyType = ToyTypes.BALL;
	private BallTypeOfGame typeOfGame;			// (football, basketball and etc.)

	public Ball() {
		super();
	}
	
	public Ball(AgeGroupType ageGroup, SizeType size, double cost, BallTypeOfGame ballGame) {
		super(toyType, ageGroup, size, cost);
		this.typeOfGame = ballGame;
	}

	public BallTypeOfGame getTypeOfGame() {
		return typeOfGame;
	}

	public void setTypeOfGame(BallTypeOfGame typeOfGame) {
		this.typeOfGame = typeOfGame;
	}

	@Override
	public String toString() {
		return "Ball [" + (typeOfGame != null ? "typeOfGame=" + typeOfGame : "") + "]";
	}

	
	
	
}
