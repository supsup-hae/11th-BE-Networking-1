package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController implements GameController {

	private static final String SEPARATOR = ",";

	private final RandomNumberGenerator generator;
	private final InputView inputView;
	private final OutputView outputView;
	private RacingGame racingGame;

	public RacingGameController(RandomNumberGenerator generator, InputView inputView, OutputView outputView) {
		this.generator = generator;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	@Override
	public void prepare() {
		List<Car> cars = loadingPlayers(inputView.askCarName());
		int trial = Integer.parseInt(inputView.askTrial());
		racingGame = new RacingGame(cars, trial);
	}

	@Override
	public void start() {
		outputView.printExecutionResult();
		for (int i = 0; i < racingGame.getTrial(); i++) {
			executeOneTrial();
		}
	}

	@Override
	public void finish() {
		List<Car> winners = racingGame.getWinners();
		outputView.printRaceResults(winners);
	}

	private static List<Car> loadingPlayers(String players) {
		return Arrays.stream(players.split(SEPARATOR)).map(Car::create).toList();
	}

	private void executeOneTrial() {
		racingGame.moveForwardCarsWithRandomNumber(generator);
		outputView.printGameTrialStatus(racingGame);
	}
}
