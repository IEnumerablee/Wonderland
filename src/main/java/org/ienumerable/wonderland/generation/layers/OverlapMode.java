package org.ienumerable.wonderland.generation.layers;

public interface OverlapMode<T> {
    T overlap(T t1, T t2);
}
