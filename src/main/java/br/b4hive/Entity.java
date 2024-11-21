package br.b4hive;

import java.awt.*;

public class Entity {
    private final String name;
    private Point position;

    public Entity(String name, Point position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
}
