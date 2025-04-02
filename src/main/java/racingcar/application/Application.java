package racingcar.application;

import racingcar.controller.GameController;
import racingcar.controller.RacingGameController;
import racingcar.util.RacingCarNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		GameController racingGameController = new RacingGameController(
			new RacingCarNumberGenerator(),
			new InputView(),
			new OutputView()
		);

		racingGameController.prepare();
		racingGameController.start();
		racingGameController.finish();
	}
}