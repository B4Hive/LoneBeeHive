package br.b4hive;

import java.util.HashMap;
import java.util.Map;

public class MapGrid {
    private Map<Coordinate, Tile> map;

    public MapGrid() {
        map = new HashMap<>();
    }
    public MapGrid(Map<Coordinate, Tile> map) {
        this.map = map;
    }
    public Tile get(Coordinate p) {
        if(!map.containsKey(p)) {
            map.put(p, new Tile());
        }
        return map.get(p);
    }
    public void changeMap(Map<Coordinate, Tile> newMap) {
        map = newMap;
    }
}
