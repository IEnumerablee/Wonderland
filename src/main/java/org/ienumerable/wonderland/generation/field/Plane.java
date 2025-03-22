package org.ienumerable.wonderland.generation.field;

public class Plane extends Field{
    private final int y;

    public Plane(int y) {
        this.y = y;
    }

    @Override
    public Boolean getPos(int x, int y, int z) {
        return y == this.y;
    }
}
