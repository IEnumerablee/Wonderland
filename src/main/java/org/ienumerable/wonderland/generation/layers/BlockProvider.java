package org.ienumerable.wonderland.generation.layers;

public interface BlockProvider<T> {
    Signature<T> get(int x, int y, int z);
}
