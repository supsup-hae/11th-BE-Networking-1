package racingcar.model;

import static racingcar.enums.CarConstant.*;
import static racingcar.message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.exception.GameException;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

	private final List<Car> cars;
	private final int trial;

	public RacingGame(List<Car> cars, int trial) {
		validateNullList(cars);
		validateEmptyList(cars);
		validateDuplicateName(cars);
		validateTrial(trial);
		this.cars = new ArrayList<>(cars);
		this.trial = trial;
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	public int getTrial() {
		return trial;
	}

	public void moveForwardCarsWithRandomNumber(RandomNumberGenerator randomNumberGenerator) {
		cars.forEach(car -> {
			if (randomNumberGenerator.generate() >= MOVE_FORWARD_THRESHOLD.getValue()) {
				car.moveForward();
			}
		});
	}

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.toList();
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(INITIAL_POSITION.getValue());
	}

	private void validateEmptyList(List<Car> cars) {
		if (cars.isEmpty()) {
			throw new GameException(EMPTY_CAR_LIST);
		}
	}

	private void validateNullList(List<Car> cars) {
		if (cars == null) {
			throw new GameException(NULL_LIST);
		}
	}

	private void validateDuplicateName(List<Car> cars) {
		if (hasDuplicateName(cars)) {
			throw new GameException(DUPLICATE_CAR_NAME);
		}
	}

	private void validateTrial(int trial) {
		if (trial < MINIMUM_TRIAL_COUNT.getValue()) {
			throw new GameException(INVALID_TRIAL_COUNT);
		}
	}

	private boolean hasDuplicateName(List<Car> cars) {
		return cars.stream()
			.map(Car::getName)
			.distinct()
			.count() != cars.size();
	}

}
