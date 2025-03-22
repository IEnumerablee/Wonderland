package org.ienumerable.wonderland.generation.layers;

public class Signature<T>{
    private final int x, y, z;
    private T v;

    public Signature(int z, int y, int x, T v) {
        this.v = v;
        this.z = z;
        this.y = y;
        this.x = x;
    }

    public Signature(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.v = null;
    }

    public void overlap(Signature<T> layer, OverlapMode<T> rule){
        if(v == null) v = layer.v;
        else v = rule.overlap(layer.v(), v);
    }

    public T v() {
        return v;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int z() {
        return z;
    }
}
