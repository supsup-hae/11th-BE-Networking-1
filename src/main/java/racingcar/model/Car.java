package racingcar.model;

import static racingcar.enums.CarConstant.*;
import static racingcar.message.ErrorMessage.*;
import static racingcar.message.OutPutMessage.*;

import racingcar.exception.GameException;

public class Car {
	private final String name;
	private int position;

	public Car(String name, int position) {
		validateNull(name);
		validateEmptyName(name);
		validateNameLength(name);
		this.name = name;
		this.position = position;
	}

	public static Car create(String name) {
		return new Car(name, INITIAL_POSITION.getValue());
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveForward() {
		this.position++;
	}

	@Override
	public String toString() {
		return String.format(RACE_PROGRESS_FORMAT.getMessage(), name, convertToBar(position));
	}

	private String convertToBar(int position) {
		return "-".repeat(position);
	}

	private void validateNameLength(String name) {
		if (name.length() >= NAME_MAX_LENGTH.getValue()) {
			throw new GameException(INVALID_NAME_LENGTH);
		}
	}

	private void validateEmptyName(String name) {
		if (name.isEmpty()) {
			throw new GameException(EMPTY_NAME);
		}
	}

	private void validateNull(String name) {
		if (name == null) {
			throw new GameException(NULL_NAME);
		}
	}

}