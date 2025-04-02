package racingcar.exception;

import racingcar.message.ErrorMessage;

public class GameException extends IllegalArgumentException {
	public GameException(final ErrorMessage errorMessage) {
		super(errorMessage.getMessage());

	}

}
