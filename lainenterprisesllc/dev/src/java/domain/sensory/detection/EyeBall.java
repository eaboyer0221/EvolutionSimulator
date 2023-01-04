package java.domain.sensory.detection;

import java.domain.Cardinal;
import java.domain.GridMap;
import java.domain.sensory.detection.interfaces.Sighter;
import java.domain.sensory.sensoryconcepts.PhysicalItem;
import java.util.List;

public class EyeBall implements Sighter<PhysicalItem> {
	public final int affinity;
	
	public EyeBall(int affinity) {
		this.affinity = affinity;
	}
	
	@Override public List<PhysicalItem> lookat(
	 GridMap map,
	 int i,
	 int j, Cardinal direction,
	 int distance
	) {
		
		// Generate a list of locations in the 
		// forward-direction sector,
		// at most "distance" away
		return null;
	}
}
