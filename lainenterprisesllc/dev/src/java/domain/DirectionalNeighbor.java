package java.domain;

public interface DirectionalNeighbor<T> {
	public Degrees value();
	public Pair<Integer, Integer> getStepSizes();
	
	int getDistanceToBorderInDirection(int x, int y, int width, int height);
	public boolean isCardinal();
	public String name();
	T getNextAngle();
	T getPreviousAngle();
}

