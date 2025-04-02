package racingcar.enums;

public enum CarConstant {
	INITIAL_POSITION(0),
	MOVE_FORWARD_THRESHOLD(4),
	NAME_MAX_LENGTH(5),
	MINIMUM_TRIAL_COUNT(1);

	private final int value;

	private CarConstant(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
