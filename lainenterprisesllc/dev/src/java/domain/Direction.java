package java.domain;

public interface Direction {
	public int value();
	public Pair<Integer, Integer> getStepSizes();
	
	int getDistanceToBorderInDirection(int x, int y, int width, int height);
	
}

