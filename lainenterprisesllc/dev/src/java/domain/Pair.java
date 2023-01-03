package java.domain;

import java.util.AbstractMap;

public class Pair<k, v> extends AbstractMap.SimpleEntry<k, v> {
	public Pair(k key, v value) {
		super(key, value);
	}
}
