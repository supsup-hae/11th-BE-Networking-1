package racingcar.message;

public enum InputMessage implements Message {
	CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

	TRIAL_COUNT_PROMPT("시도할 회수는 몇회인가요?");

	private final String message;

	private InputMessage(final String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
