package java.domain;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Degrees {
	_0(0),
	_45(45),
	_90(90),
	_135(135),
	_180(180),
	_225(225),
	_270(270),
	_315(315),
	;
	public final int value;
	
	Degrees(int value) {
		this.value = value;
	}
	
	public Double getPheromoneGradientInDirection(GridMap map, int i,
	 int j
	) {
		return map.getCollinearLocations(this, i, j)
		 .collect(Collectors.averagingInt(x -> x.pheromoneLevel));
	}
	private static final Map<Degrees, Degrees> nextMap = Map.ofEntries(
	 entry(_0, _45),
	 entry(_45, _90),
	 entry(_90, _135),
	 entry(_135, _180),
	 entry(_180, _225),
	 entry(_225, _270),
	 entry(_270, _315),
	 entry(_315, _0)
	 );
	private static final Map<Degrees, Degrees> previousMap = Map.ofEntries(
	 entry(_0, _315),
	 entry(_45, _0),
	 entry(_90, _45),
	 entry(_135, _90),
	 entry(_180, _135),
	 entry(_225, _180),
	 entry(_270, _225),
	 entry(_315, _270)
	 );
	private static AbstractMap.SimpleImmutableEntry<Degrees, Degrees> entry(Degrees a, Degrees b) {
		return new AbstractMap.SimpleImmutableEntry<>(a, b);
	}
	public Degrees next(){
		return nextMap.get(this);
	}
	
	public Degrees previous(){
		return previousMap.get(this);
	}
}
