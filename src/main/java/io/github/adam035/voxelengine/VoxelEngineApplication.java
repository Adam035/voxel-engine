package io.github.adam035.voxelengine;

import io.github.adam035.voxelengine.core.VoxelEngine;

public class VoxelEngineApplication {
    public static void main(String[] args) {
        VoxelEngine voxelEngine = VoxelEngine.getInstance();
        voxelEngine.run();
    }
}
