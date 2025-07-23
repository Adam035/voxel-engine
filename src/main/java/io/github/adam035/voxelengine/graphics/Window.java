package io.github.adam035.voxelengine.graphics;

import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private final static String TITLE = "Voxel Engine";
    private final static int WIDTH = 1280, HEIGHT = 720;
    private final static float[] BACKGROUND_COLOR_RGBA = new float[] {0.53f, 0.8f, 0.92f, 1f};
    private static Window instance;
    private long windowHandle;

    private Window() {}

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    public void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        windowHandle = glfwCreateWindow(WIDTH, HEIGHT, TITLE, NULL, NULL);
        if (windowHandle == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(windowHandle);
        glfwSwapInterval(1);
        glfwShowWindow(windowHandle);

        GL.createCapabilities();

        float red = BACKGROUND_COLOR_RGBA[0];
        float green = BACKGROUND_COLOR_RGBA[1];
        float blue = BACKGROUND_COLOR_RGBA[2];
        float alpha = BACKGROUND_COLOR_RGBA[3];
        org.lwjgl.opengl.GL11.glClearColor(red, green, blue, alpha);
    }

    public void update() {
        glfwSwapBuffers(windowHandle);
        glfwPollEvents();
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(windowHandle);
    }

    public void cleanup() {
        glfwFreeCallbacks(windowHandle);
        glfwDestroyWindow(windowHandle);
        glfwTerminate();
    }
}
