package org.ienumerable.wonderland.generation.surface;

import org.bukkit.Material;
import org.ienumerable.wonderland.generation.field.Field;
import org.ienumerable.wonderland.generation.field.FieldMode;
import org.ienumerable.wonderland.generation.layers.BlockProvider;
import org.ienumerable.wonderland.generation.layers.LayerStack;
import org.ienumerable.wonderland.generation.layers.Signature;

import java.util.List;

public class Surface implements BlockProvider<Material> {
    private final List<Material> ones, zeros;
    private final LayerStack<Boolean> fieldStack = new LayerStack<>();

    public Surface(String namespace, List<Material> z, List<Material> o, List<String> layers) {
        this.zeros = z;
        this.ones = o;
        this.fieldStack.parse(namespace, layers, FieldMode.class, Field.class);
    }

    @Override
    public Signature<Material> get(int x, int y, int z) {
        List<Material> available_blocks = fieldStack.apply(x, y, z) ? ones : zeros;
        Material material = available_blocks.size() == 1 ? available_blocks.getFirst() : available_blocks.get((int) (Math.random() * available_blocks.size()));
        return new Signature<Material>(x, y, z, material);
    }
}
