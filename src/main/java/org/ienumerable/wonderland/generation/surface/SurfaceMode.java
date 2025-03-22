package org.ienumerable.wonderland.generation.surface;

import org.bukkit.Material;
import org.ienumerable.wonderland.generation.layers.OverlapMode;

import java.util.function.BiFunction;

public enum SurfaceMode implements OverlapMode<Material> {
    OVERLAY((m1, m2) -> m2),
    RANDOM((m1, m2) -> Math.random() > 0.5 ? m1 : m2),
    DURABILITY((m1, m2) -> m1.getMaxDurability() > m2.getMaxDurability() ? m1 : m2);

    private final BiFunction<Material, Material, Material> mode;
    public Material overlap(Material x1, Material x2){
        return mode.apply(x1, x2);
    }

    SurfaceMode(BiFunction<Material, Material, Material> mode) {
        this.mode = mode;
    }
}
