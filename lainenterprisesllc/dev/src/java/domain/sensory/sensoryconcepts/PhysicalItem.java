package java.domain.sensory.sensoryconcepts;

import java.domain.sensory.emission.interfaces.Sightable;

public class PhysicalItem extends SenseEntity  implements Sightable<PhysicalItem> {
	public int visibilityLevel;
	@Override public PhysicalItem show(int threshold) {
		// Todo if the threshold is above visibilityLevel, then return "this". otherwise, null
		return null;
	}
}
