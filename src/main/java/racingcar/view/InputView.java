package racingcar.view;

import static racingcar.message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public String askCarName() {
		System.out.println(CAR_NAME_PROMPT.getMessage());
		return Console.readLine();
	}

	public String askTrial() {
		System.out.println(TRIAL_COUNT_PROMPT.getMessage());
		return Console.readLine();
	}

}
