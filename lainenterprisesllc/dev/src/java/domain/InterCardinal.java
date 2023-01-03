package java.domain;

import static java.domain.Cardinal.Theta.*;

public class InterCardinal {
	public final Theta theta;
	
	enum Theta implements Direction {
		_45_DEGREES(45),
		_135_DEGREES(135),
		_225_DEGREES(225),
		_315_DEGREES(315);
		public final int angle;
		
		Theta(int i) {
			this.angle = i;
		}
		
		@Override public int value() {
			return this.angle;
		}
		
		public Pair<Integer, Integer> getStepSizes() {
			return this == _45_DEGREES ? new Pair<>(1, 0):
				this == _135_DEGREES ? new Pair<>(1, 1):
				this == _225_DEGREES ? new Pair<>(0, 1):
				/*this == _315_DEGREES ? */ new Pair<>(-1, 1);
		}
		@Override public int getDistanceToBorderInDirection(int x, int y, int width, int height) {
			return this == _45_DEGREES ? minimumBorderDistance(x, y, width, height, _0_DEGREES, _90_DEGREES) :
			 this == _135_DEGREES ? minimumBorderDistance(x, y, width, height,  _90_DEGREES, _180_DEGREES) :
			 this == _225_DEGREES ? minimumBorderDistance(x, y, width, height, _180_DEGREES, _270_DEGREES) :
			 /*this ==_315_DEGREES ?*/ minimumBorderDistance(x, y, width, height, _270_DEGREES, _0_DEGREES);
		}
		
		@Override public boolean isCardinal() {
			return false;
		}
		
		private static int minimumBorderDistance(int x, int y, int width, int height,
		 Cardinal.Theta degrees1, Cardinal.Theta degrees2) {
			return Math.min(
			 degrees1.getDistanceToBorderInDirection(x, y, width, height),
			 degrees2.getDistanceToBorderInDirection(x, y, width, height)
			);
		}
	}
	
	public InterCardinal(Theta theta) {
		this.theta = theta;
	}
}
