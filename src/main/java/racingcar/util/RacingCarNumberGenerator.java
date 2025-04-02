package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarNumberGenerator implements RandomNumberGenerator {

	@Override
	public int generate() {
		return Randoms.pickNumberInRange(0, 9);
	}
}
