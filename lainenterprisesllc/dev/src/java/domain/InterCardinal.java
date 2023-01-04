package java.domain;

import java.util.List;

import static java.domain.Cardinal.PiOverTwoTimes.*;
class Meta {
	private static class Angle<Radians, Degrees, AngleType, NeighborType> {
		public final AngleType angleType;
		public final Degrees degrees;
		public final NeighborType neighborType;
		public final Radians radians;
		public Angle<Radians, Degrees, NeighborType, AngleType> previous;
		public Angle<Radians, Degrees, NeighborType, AngleType> next;
		
		public Angle(
		 AngleType angleType,
		 Degrees degrees,
		 NeighborType neighborType,
		 Radians radians
		 	) {
			this.angleType = angleType;
			this.degrees = degrees;
			this.neighborType = neighborType;
			this.radians = radians;
			this.previous = null;
			this.next = null;
		}
		public void setPrevious(Angle<Radians, Degrees, NeighborType, AngleType> previous){
			if(this.previous == null) {
				this.previous = previous;
			}
		}
		public void setNext(Angle<Radians, Degrees, NeighborType, AngleType> next) {
			if(this.next == null) {
				this.next = next;
			}
		}
	}
	
	public static final List<Angle> angles = List.of(
	 new Angle<>(AngleType.CARDINAL, Degrees._0, AngleType.INTER_CARDINAL,ZERO),
	 new Angle<>(AngleType.INTER_CARDINAL, Degrees._45, AngleType.CARDINAL, InterCardinal.PiOverFourTimes.ONE), new Angle<>(AngleType.CARDINAL, Degrees._90, AngleType.INTER_CARDINAL, ONE),
	 new Angle<>(AngleType.CARDINAL, Degrees._90, AngleType.INTER_CARDINAL, ONE),
	 new Angle<>(AngleType.INTER_CARDINAL, Degrees._135, AngleType.CARDINAL, InterCardinal.PiOverFourTimes.THREE),
	 new Angle<>(AngleType.CARDINAL, Degrees._180, AngleType.INTER_CARDINAL, TWO),
	 new Angle<>(AngleType.INTER_CARDINAL, Degrees._225, AngleType.CARDINAL, InterCardinal.PiOverFourTimes.FIVE),
	 new Angle<>(AngleType.CARDINAL, Degrees._270, AngleType.INTER_CARDINAL, THREE),
	 new Angle<>(AngleType.INTER_CARDINAL, Degrees._315, AngleType.CARDINAL, InterCardinal.PiOverFourTimes.SEVEN)
	);
	static {
		var it = angles.iterator();
		Angle first = it.next();
		Angle prev = first;
		while(it.hasNext()) {
			Angle current = it.next();          
			current.setPrevious(prev);
			prev.setNext(current);
			prev = current;
		}
		first.setPrevious(prev);
		prev.setNext(first);
	}
	
}

public class InterCardinal {
	public final PiOverFourTimes theta;
	
	enum PiOverFourTimes implements DirectionalNeighbor<Cardinal.PiOverTwoTimes> {
		ONE(Degrees._0),
		THREE(Degrees._135),
		FIVE(Degrees._225),
		SEVEN(Degrees._315);
		public final Degrees degrees;
		
		PiOverFourTimes(Degrees i) {
			this.degrees = i;
		}
		
		@Override public Degrees value() {
			return this.degrees;
		}
		
		public Pair<Integer, Integer> getStepSizes() {
			return this == ONE ? new Pair<>(1, 0):
				this == THREE ? new Pair<>(1, 1):
				this == FIVE ? new Pair<>(0, 1):
				/*this == _315_DEGREES ? */ new Pair<>(-1, 1);
		}
		@Override public int getDistanceToBorderInDirection(int x, int y, int width, int height) {
			return this == ONE ? minimumBorderDistance(x, y, width, height, ZERO, Cardinal.PiOverTwoTimes.ONE) :
			 this == THREE ? minimumBorderDistance(x, y, width, height, Cardinal.PiOverTwoTimes.ONE, TWO) :
			 this == FIVE ? minimumBorderDistance(x, y, width, height, TWO, Cardinal.PiOverTwoTimes.THREE) :
			 /*this ==_315_DEGREES ?*/ minimumBorderDistance(x, y, width, height, Cardinal.PiOverTwoTimes.THREE, ZERO);
		}
		
		@Override public boolean isCardinal() {
			return false;
		}
		
		@Override public Cardinal.PiOverTwoTimes getNextAngle() {
			return this.next;
		}
		
		@Override public Cardinal.PiOverTwoTimes getPreviousAngle() {
			return this.previous;
		}
		
		private static int minimumBorderDistance(int x, int y, int width, int height,
		 Cardinal.PiOverTwoTimes degrees1, Cardinal.PiOverTwoTimes degrees2) {
			return Math.min(
			 degrees1.getDistanceToBorderInDirection(x, y, width, height),
			 degrees2.getDistanceToBorderInDirection(x, y, width, height)
			);
		}
	}
	
	public InterCardinal(PiOverFourTimes theta) {
		this.theta = theta;
	}
}
