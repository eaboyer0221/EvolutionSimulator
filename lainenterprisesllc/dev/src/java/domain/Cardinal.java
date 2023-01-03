package java.domain;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Cardinal {
	public final Theta theta;
	
	public static InterCardinal.Theta from(Neuron neuron) {
		if(!neuron.direction.isCardinal()) {
			throw new InputMismatchException();
		}
		return Arrays.stream(InterCardinal.Theta.values())
		 .filter(x -> x.angle == neuron.degrees)
		 .findAny().get();
	}
	
	enum Theta implements Direction {
		_0_DEGREES(0),
		_90_DEGREES(90),
		_180_DEGREES(180),
		_270_DEGREES(270),
		;
		public final int angle;
		
		Theta(int i) {
			this.angle = i;
		}
		
		@Override public int value() {
			return this.angle;
		}
		
		public Pair<Integer, Integer> getStepSizes() {
			return this == _0_DEGREES ? new Pair<>(1, 0):
				 this == _90_DEGREES ? new Pair<>(0, 1):
				 this == _180_DEGREES ? new Pair<>(-1, 0):
				 /*this ==_270_DEGREES ?*/ new Pair<>(0, -1);
		}
		
		@Override public int getDistanceToBorderInDirection(int x, int y, int width, int height) {
				return this == _0_DEGREES ? width - x:
				 this == _90_DEGREES ? y:
				 this == _180_DEGREES ? x:
				 /*this ==_270_DEGREES ?*/ height - y;
		}
		
		@Override public boolean isCardinal() {
			return true;
		}
	}
	
	public Cardinal(Theta theta) {
		this.theta = theta;
	}
}
