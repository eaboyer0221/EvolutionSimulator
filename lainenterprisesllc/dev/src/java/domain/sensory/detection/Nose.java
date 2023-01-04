package java.domain.sensory.detection;

import java.domain.sensory.detection.interfaces.Smeller;
import java.domain.sensory.sensoryconcepts.Pheremone;
import java.util.List;

public class Nose implements Smeller<Pheremone> {
	public final int smellingAffinity;
	
	public Nose(int smellingAffinity) {
		this.smellingAffinity = smellingAffinity;
	}
	
	@Override public List<Pheremone> smell() {
		return null;
	}
}
