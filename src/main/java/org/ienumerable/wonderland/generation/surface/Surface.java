package org.ienumerable.wonderland.generation.surface;

import org.bukkit.Material;
import org.ienumerable.wonderland.generation.layers.BlockProvider;
import org.ienumerable.wonderland.generation.layers.Layer;
import org.ienumerable.wonderland.generation.layers.LayerStack;
import org.ienumerable.wonderland.generation.layers.Signature;

import java.util.List;

public class Surface implements BlockProvider<Material> {
    private final List<Material> ones, zeros;
    private final LayerStack<Boolean> fields = new LayerStack<>();

    public Surface(List<Material> z, List<Layer<Boolean>> fields, List<Material> o) {
        this.zeros = z;
        fields.forEach(this.fields::add);
        this.ones = o;
    }

    @Override
    public Signature<Material> get(int x, int y, int z) {
        List<Material> available_blocks = fields.apply(x, y, z) ? ones : zeros;
        Material material = available_blocks.size() == 1 ? available_blocks.getFirst() : available_blocks.get((int) (Math.random() * available_blocks.size()));
        return new Signature<Material>(x, y, z, material);
    }
}
