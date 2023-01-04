package java.domain.sensory.emission;

import java.domain.sensory.emission.interfaces.Hearable;
import java.domain.sensory.sensoryconcepts.Bark;

public class VoiceBox implements Hearable<Bark> {
	@Override public Bark makeSound(int decibels) {
		return null;
	}
}
