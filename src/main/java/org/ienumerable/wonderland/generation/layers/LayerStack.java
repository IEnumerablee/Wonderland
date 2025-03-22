package org.ienumerable.wonderland.generation.layers;

import java.util.ArrayList;
import java.util.List;

public class LayerStack<T> {

    private final List<Layer<T>> layers = new ArrayList<>();

    public void add(Layer<T> layer){
        layers.add(layer);
    }

    public T apply(int x, int y, int z){
        Signature<T> signature = new Signature<T>(x, y, z);
        layers.forEach(layer -> layer.overlap(signature));
        return signature.v();
    }

}
