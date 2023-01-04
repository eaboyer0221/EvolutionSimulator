package java.domain.sensory.emission;

import java.domain.sensory.emission.interfaces.Smellable;
import java.domain.sensory.sensoryconcepts.Pheremone;

public class Armpit implements Smellable<Pheremone> {
	// Todo if the threshold is above emissionLevel, then return "this". otherwise, null
	public final int emissionLevel;
	
	public Armpit(int emissionLevel) {
		this.emissionLevel = emissionLevel;
	}
	
	@Override public Pheremone emit(int threshold) {
		return null;
	}
}
