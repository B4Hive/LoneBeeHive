package br.b4hive;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MapGrid {
    private Map<Point, Tile> map;

    public MapGrid() {
        map = new HashMap<Point, Tile>();
    }
    public MapGrid(Map<Point, Tile> map) {
        this.map = map;
    }
    public Tile get(Point p) {
        if(!map.containsKey(p)) {
            map.put(p, new Tile());
        }
        return map.get(p);
    }
}
