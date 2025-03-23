package org.ienumerable.wonderland.generation.layers;

import org.ienumerable.wonderland.generation.Repository;

import java.util.ArrayList;
import java.util.List;

public class LayerStack<T> {

    private final List<Layer<T>> layers = new ArrayList<>();

    public T apply(int x, int y, int z) {
        Signature<T> signature = new Signature<T>(x, y, z);
        layers.forEach(layer -> layer.overlap(signature));
        return signature.v();
    }

    public void add(Layer<T> layer) {
        layers.add(layer);

    }

    public <R extends Enum<R> & OverlapMode<T>> void parse(String namespace, List<String> layers, Class<R> overlapRules, Class<? extends BlockProvider<T>> layersType){
        for (String layerStr : layers){
            String[] parts = layerStr.strip().split(" ");
            OverlapMode<T> overlapRule = parts.length == 1 ? null : Enum.valueOf(overlapRules, parts[1]);
            BlockProvider<T> layer = (BlockProvider<T>) Repository.get(namespace, parts[0], layersType);
            add(new Layer<>(layer, overlapRule));
        }
    }
}
