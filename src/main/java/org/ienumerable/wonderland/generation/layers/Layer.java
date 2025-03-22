package org.ienumerable.wonderland.generation.layers;

public record Layer<T>(BlockProvider<T> layer, OverlapMode<T> overlapMode) {

    public void overlap(Signature<T> signature1) {
        Signature<T> signature2 = layer.get(signature1.x(), signature1.y(), signature1.z());
        signature1.overlap(signature2, overlapMode);
    }
}
