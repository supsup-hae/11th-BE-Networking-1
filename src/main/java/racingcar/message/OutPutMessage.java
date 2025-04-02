package racingcar.message;

public enum OutPutMessage implements Message {
	EXECUTION_RESULT("\n실행 결과"),

	RACE_PROGRESS_FORMAT("%s : %s"),

	WINNERS_ANNOUNCEMENT("최종 우승자 : ");

	private final String message;

	private OutPutMessage(final String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
