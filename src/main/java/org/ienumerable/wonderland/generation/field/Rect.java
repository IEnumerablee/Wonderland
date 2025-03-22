package org.ienumerable.wonderland.generation.field;

public class Rect extends Field{

    private final int x1, y1, z1, x2, y2, z2;

    public Rect(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);;
        this.z1 = Math.min(z1, z2);;
        this.x2 = Math.max(x1, x2);;
        this.y2 = Math.max(y1, y2);;
        this.z2 = Math.max(z1, z2);;
    }

    @Override
    public Boolean getPos(int x, int y, int z) {
        if(x < x1 || x > x2) return false;
        if(y < y1 || y > y2) return false;
        if(z < z1 || z > z2) return false;
        return true;
    }
}
