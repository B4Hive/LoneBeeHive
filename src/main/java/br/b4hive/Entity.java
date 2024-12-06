package br.b4hive;

public class Entity {
    private final String name;
    private Coordinate position;

    public Entity(String name, Coordinate position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public Coordinate getPosition() {
        return position;
    }
    public void setPosition(Coordinate position) {
        this.position = position;
    }
}
