package io.github.adam035.voxelengine.core;

import io.github.adam035.voxelengine.graphics.Window;
import org.lwjgl.opengl.GL11;

public class VoxelEngine {
    private static VoxelEngine instance;
    private final Window window;
    private boolean running;

    private VoxelEngine() {
        window = Window.getInstance();
        window.init();
    }

    public static VoxelEngine getInstance() {
        if (instance == null) {
            instance = new VoxelEngine();
        }
        return instance;
    }

    public void run() {
        running = true;
        while (running && !window.shouldClose()) {
            loop();
        }
        cleanup();
    }


    private void loop() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        // TODO: logic

        window.update();
    }

    private void cleanup() {
        window.cleanup();
    }
}
