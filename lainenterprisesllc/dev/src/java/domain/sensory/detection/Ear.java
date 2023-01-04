package java.domain.sensory.detection;

import java.domain.sensory.detection.interfaces.Listener;
import java.domain.sensory.sensoryconcepts.Bark;
import java.util.List;


public class Ear implements Listener<Bark> {
	public final int hearingAffinity;
	
	public Ear(int hearingAffinity) {
		this.hearingAffinity = hearingAffinity;
	}
	
	@Override public List<Bark> listen(int decibels) {
		return null;
	}
}


