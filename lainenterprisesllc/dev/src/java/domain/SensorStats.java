package java.domain;

public class SensorStats {
	public final double pheremonelevel;
	public final float populationDensity;
	
	public SensorStats(double pheremoneLevel, float populationDensity, int borderDistance) {
		this.pheremonelevel = pheremoneLevel;
		this.populationDensity = populationDensity;
		this.borderDistance = borderDistance;
	}
	
	public final int borderDistance;
}
