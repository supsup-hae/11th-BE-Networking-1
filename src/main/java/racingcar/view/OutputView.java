package racingcar.view;

import static racingcar.message.OutPutMessage.*;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingGame;

public class OutputView {
	private final static String SEPARATOR = ", ";

	public void printExecutionResult() {
		System.out.println(EXECUTION_RESULT.getMessage());
	}

	public void printGameTrialStatus(RacingGame racingGame) {
		racingGame.getCars().stream().map(Car::toString).forEach(System.out::println);
		System.out.println();
	}

	public void printRaceResults(List<Car> winnerList) {
		System.out.print(WINNERS_ANNOUNCEMENT.getMessage() + convertToResult(winnerList));
		Console.close();
	}

	private String convertToResult(List<Car> winnerList) {
		return winnerList.stream()
			.map(Car::getName)
			.collect(Collectors.joining(SEPARATOR));
	}

}
