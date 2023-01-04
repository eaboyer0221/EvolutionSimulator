package java.domain.sensory.detection.interfaces;

import java.util.List;

public interface Listener<T> {
	public List<T> listen(int decibels);
}
