package java.domain;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Cardinal {
	public final PiOverTwoTimes piOverTwoTimes;
	
	/*public static InterCardinal.PiOverFourTimes from(Degrees degrees) {
		if(!degrees.isCardinal()) {
			throw new InputMismatchException();
		}
		return Arrays.stream(InterCardinal.PiOverFourTimes.values())
		 .filter(x -> x.degrees.value == degrees.value)
		 .findAny().get();
	}
	*/
	enum PiOverTwoTimes implements DirectionalNeighbor<InterCardinal.PiOverFourTimes> {
		ZERO(Degrees._0),
		ONE(Degrees._90),
		TWO(Degrees._180),
		THREE(Degrees._270),
		;
		public final Degrees degrees;
		private InterCardinal.PiOverFourTimes next;
		private InterCardinal.PiOverFourTimes previous;
		
		PiOverTwoTimes(Degrees i) {
			this.degrees = i;
		}
		
		@Override public Degrees value() {
			return this.degrees;
		}
		
		public Pair<Integer, Integer> getStepSizes() {
			return this == ZERO ? new Pair<>(1, 0):
				 this == ONE ? new Pair<>(0, 1):
				 this == TWO ? new Pair<>(-1, 0):
				 /*this ==_270_DEGREES ?*/ new Pair<>(0, -1);
		}
		
		@Override public int getDistanceToBorderInDirection(int x, int y, int width, int height) {
				return this == ZERO ? width - x:
				 this == ONE ? y:
				 this == TWO ? x:
				 /*this ==_270_DEGREES ?*/ height - y;
		}
		
		@Override public boolean isCardinal() {
			return true;
		}
		
		@Override public InterCardinal.PiOverFourTimes getNextAngle() {
			return this.next;
		}
		
		@Override public InterCardinal.PiOverFourTimes getPreviousAngle() {
			return this.previous;
		}
	}
	
	public Cardinal(PiOverTwoTimes piOverTwoTimes) {
		this.piOverTwoTimes = piOverTwoTimes;
	}
}
