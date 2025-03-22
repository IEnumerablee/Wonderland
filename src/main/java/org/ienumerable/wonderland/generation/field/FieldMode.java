package org.ienumerable.wonderland.generation.field;

import org.ienumerable.wonderland.generation.layers.OverlapMode;

import java.util.function.BiFunction;

public enum FieldMode implements OverlapMode<Boolean> {
    AND((x1, x2) -> x1 && x2),
    NAND((x1, x2) -> !(x1 && x2)),
    OR((x1, x2) -> x1 || x2),
    NOR((x1, x2) -> !(x1 || x2)),
    XOR((x1, x2) -> x1 != x2);

    private final BiFunction<Boolean, Boolean, Boolean> mode;
    public Boolean overlap(Boolean x1, Boolean x2){
        return mode.apply(x1, x2);
    }

    FieldMode(BiFunction<Boolean, Boolean, Boolean> mode) {
        this.mode = mode;
    }
}
