package racingcar.message;

public enum ErrorMessage implements Message {

	INVALID_NAME_LENGTH("이름의 길이는 5자 이하여야 합니다."),

	EMPTY_NAME("이름이 비어 있습니다."),

	NULL_NAME("이름이 NULL 입니다."),

	EMPTY_CAR_LIST("자동차 목록이 비어있습니다."),

	DUPLICATE_CAR_NAME("중복된 이름의 자동차가 존재합니다."),

	INVALID_TRIAL_COUNT("시도 횟수는 1 이상이어야 합니다."),

	NULL_LIST("List 가 NULL 입니다.");

	private final String message;

	private ErrorMessage(final String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	}
