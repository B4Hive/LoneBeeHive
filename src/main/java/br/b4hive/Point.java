package br.b4hive;

public record Point(int x, int y) {

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point translate(int x, int y) {
        return new Point(this.x + x, this.y + y);
    }

}

