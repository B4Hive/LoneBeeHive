package br.b4hive;

public record Coordinate(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Coordinate translate(int x, int y) {
        return new Coordinate(this.x + x, this.y + y);
    }

}

