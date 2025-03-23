package org.ienumerable.wonderland.generation;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.ienumerable.wonderland.generation.layers.LayerStack;
import org.ienumerable.wonderland.generation.surface.Surface;
import org.ienumerable.wonderland.generation.surface.SurfaceMode;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class Demiurge extends ChunkGenerator {

    private final LayerStack<Material> surfaceStack;

    public Demiurge(String namespace, List<String> surfaceLayers) {
        this.surfaceStack = new LayerStack<>();
        this.surfaceStack.parse(namespace, surfaceLayers, SurfaceMode.class, Surface.class);
    }

    @Override
    public void generateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int X = chunkX * 16 + x;
                int Z = chunkZ * 16 + z;
                for (int Y = -64; Y < 320; Y++) {
                    chunkData.setBlock(X, Y, Z, surfaceStack.apply(X, Y, Z));
                }
            }
        }
    }
}