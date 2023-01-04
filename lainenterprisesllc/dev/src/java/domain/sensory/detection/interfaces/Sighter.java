package java.domain.sensory.detection.interfaces;

import java.domain.Cardinal;
import java.domain.GridMap;
import java.domain.sensory.sensoryconcepts.PhysicalItem;
import java.util.List;

// An eyeBall
public interface Sighter<T> {
	List<PhysicalItem> lookat(
	 GridMap map, int i, int j, Cardinal direction, int distance
	);
}
